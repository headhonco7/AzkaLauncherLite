/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.karuhun.feature.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices.TV_1080p
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.karuhun.core.ui.navigation.extension.collectWithLifecycle
import com.karuhun.feature.home.ui.model.MenuItem
import com.karuhun.launcher.core.designsystem.R
import com.karuhun.launcher.core.designsystem.component.FacebookSvgrepoCom
import com.karuhun.launcher.core.designsystem.component.InstagramFSvgrepoCom
import com.karuhun.launcher.core.designsystem.component.LauncherCard
import com.karuhun.launcher.core.designsystem.component.MenuItemCard
import com.karuhun.launcher.core.designsystem.component.WifiInfoCard
import com.karuhun.launcher.core.designsystem.component.WhatsappInfoCard
import com.karuhun.launcher.core.designsystem.component.ZoomOverlay
import com.karuhun.launcher.core.designsystem.icon.MoreSvgrepoCom
import com.karuhun.launcher.core.designsystem.theme.AppTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import java.net.URLEncoder

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeContract.UiState,
    uiAction: (HomeContract.UiAction) -> Unit,
    uiEffect: Flow<HomeContract.UiEffect>,
    onMenuItemClick: (String) -> Unit = { _ -> },
    onGoToMainMenu: () -> Unit,

    // WiFi
    wifiSsid: String = "",
    wifiPassword: String = "",

    // WhatsApp (DISPLAY untuk tamu)
    whatsappNumber: String = "",
    whatsappLabel: String = "",
) {
    var showWifiOverlay by remember { mutableStateOf(false) }
    var showWhatsappOverlay by remember { mutableStateOf(false) }

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is HomeContract.UiEffect.ShowError -> {
                // no-op for now
            }
        }
    }

    // =========================
    // Overlay WiFi + QR
    // =========================
    ZoomOverlay(
        visible = showWifiOverlay,
        title = "WiFi",
        onDismiss = { showWifiOverlay = false }
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "SSID",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.80f)
            )
            Text(
                text = if (wifiSsid.isBlank()) "Belum diisi" else wifiSsid,
                fontSize = 22.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Password",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.80f)
            )
            Text(
                text = if (wifiPassword.isBlank()) "Belum diisi" else wifiPassword,
                fontSize = 22.sp,
                color = Color.White
            )

            // ✅ QR WiFi hanya tampil kalau SSID + password ada
            if (wifiSsid.isNotBlank() && wifiPassword.isNotBlank()) {
                val payload = buildWifiQrPayload(
                    ssid = wifiSsid,
                    password = wifiPassword,
                    // Default paling umum: WPA (bisa kamu ubah nanti jika perlu)
                    security = "WPA",
                    hidden = false
                )
                val qrUrl = buildQrUrl(payload)

                Text(
                    text = "Scan QR untuk konek WiFi",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.80f)
                )

                AsyncImage(
                    model = qrUrl,
                    contentDescription = "WiFi QR",
                    modifier = Modifier.size(280.dp),
                    contentScale = ContentScale.Fit
                )
            } else {
                Text(
                    text = "QR tidak tersedia (SSID/password kosong)",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.80f)
                )
            }
        }
    }

    // =========================
    // Overlay WhatsApp + QR
    // =========================
    ZoomOverlay(
        visible = showWhatsappOverlay,
        title = if (whatsappLabel.isBlank()) "WhatsApp" else whatsappLabel,
        onDismiss = { showWhatsappOverlay = false }
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "WhatsApp",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.80f)
            )

            // ✅ Ini yang ditampilkan ke tamu: biarkan apa adanya (contoh 081....)
            Text(
                text = if (whatsappNumber.isBlank()) "Belum diisi" else whatsappNumber,
                fontSize = 22.sp,
                color = Color.White
            )

            // ✅ QR hanya muncul kalau link wa.me valid
            val waLink = buildWaLinkFromDisplayNumber(whatsappNumber)
            if (waLink.isNotBlank()) {
                val qrUrl = buildQrUrl(waLink)

                Text(
                    text = "Scan QR untuk chat",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.80f)
                )

                AsyncImage(
                    model = qrUrl,
                    contentDescription = "WhatsApp QR",
                    modifier = Modifier.size(280.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = waLink,
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.75f)
                )
            } else {
                Text(
                    text = "QR tidak tersedia (nomor tidak valid)",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.80f)
                )
            }
        }
    }

    Row(modifier = modifier) {
        LeftContent(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(start = 16.dp),
            guestName = uiState.roomDetail?.guestName.orEmpty(),

            wifiSsid = wifiSsid,
            onWifiClick = { showWifiOverlay = true },

            whatsappNumber = whatsappNumber,
            whatsappLabel = whatsappLabel,
            onWhatsappClick = { showWhatsappOverlay = true },
        )
        RightContent(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(end = 16.dp),
            onMenuItemClick = onMenuItemClick,
            onGoToMainMenu = onGoToMainMenu,
        )
    }
}

@Composable
fun LeftContent(
    modifier: Modifier = Modifier,
    guestName: String,

    // WiFi
    wifiSsid: String,
    onWifiClick: () -> Unit,

    // WhatsApp
    whatsappNumber: String,
    whatsappLabel: String,
    onWhatsappClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = stringResource(com.karuhun.feature.home.ui.R.string.feature_home_ui_welcome),
            style = MaterialTheme.typography.headlineLarge.copy(
                color = Color(0xFFEFEFEF),
                fontSize = 46.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Text(
            text = guestName,
            style = MaterialTheme.typography.headlineLarge.copy(
                color = Color(0xFFEFEFEF),
                fontSize = 46.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = stringResource(com.karuhun.feature.home.ui.R.string.feature_home_ui_welcome_text),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color(0xFFEFEFEF),
                fontWeight = FontWeight.Light
            ),
        )

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = InstagramFSvgrepoCom,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "@the_hotel",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color(0xFFEFEFEF),
                    fontWeight = FontWeight.Light,
                ),
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = FacebookSvgrepoCom,
                contentDescription = null,
                tint = Color(0xFFEFEFEF)
            )
            Text(
                text = "@the_hotel",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color(0xFFEFEFEF),
                    fontWeight = FontWeight.Light,
                ),
            )
        }

        Spacer(modifier = Modifier.height(18.dp))
        WifiInfoCard(
            ssid = wifiSsid,
            onClick = onWifiClick,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))
        WhatsappInfoCard(
            number = whatsappNumber,
            label = whatsappLabel,
            onClick = onWhatsappClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun RightContent(
    modifier: Modifier = Modifier,
    onMenuItemClick: (String) -> Unit,
    onGoToMainMenu: () -> Unit
) {
    val homeMenuItems = MenuItem.items

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(modifier = Modifier.width(320.dp)) {
            LauncherCard(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .padding(start = 8.dp, end = 8.dp),
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(R.drawable.core_designsystem_promo_2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(
                    horizontal = 8.dp,
                    vertical = 8.dp,
                ),
            ) {
                items(homeMenuItems.size) { index ->
                    MenuItemCard(
                        title = homeMenuItems[index].title,
                        icon = homeMenuItems[index].icon,
                        onClick = { onMenuItemClick(homeMenuItems[index].title) },
                    )
                }
            }
            MenuItemCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 8.dp, end = 8.dp),
                icon = MoreSvgrepoCom,
                onClick = { onGoToMainMenu() },
            )
        }
    }
}

@Preview(device = TV_1080p)
@Composable
private fun HomeScreenPreview() {
    AppTheme {
        HomeScreen(
            onMenuItemClick = {},
            uiState = HomeContract.UiState(isLoading = false),
            uiAction = {},
            uiEffect = emptyFlow(),
            onGoToMainMenu = {},

            wifiSsid = "De AZKA WiFi",
            wifiPassword = "12345678",

            whatsappNumber = "0812 3456 7890",
            whatsappLabel = "Front Office",
        )
    }
}

/**
 * Convert nomor WA DISPLAY (mis: "081...", "+62...", "62...", "8...")
 * menjadi format internasional untuk wa.me: "628..."
 */
private fun toWaMeNumberFromDisplay(input: String): String {
    val digits = input.filter { it.isDigit() }
    if (digits.isBlank()) return ""

    return when {
        digits.startsWith("62") -> digits
        digits.startsWith("0") -> "62" + digits.drop(1)
        digits.startsWith("8") -> "62$digits"
        else -> "" // format aneh -> kosong (QR disembunyikan)
    }
}

/**
 * Build wa.me link dari nomor display.
 */
private fun buildWaLinkFromDisplayNumber(displayNumber: String): String {
    val waMe = toWaMeNumberFromDisplay(displayNumber)
    return if (waMe.isBlank()) "" else "https://wa.me/$waMe"
}

/**
 * Escape khusus untuk payload QR WiFi (format "WIFI:...").
 * Karakter \ ; , : harus di-escape dengan backslash.
 */
private fun escapeWifiQrValue(value: String): String {
    return value
        .replace("\\", "\\\\")
        .replace(";", "\\;")
        .replace(",", "\\,")
        .replace(":", "\\:")
}

/**
 * Payload standar QR WiFi:
 * WIFI:T:WPA;S:<ssid>;P:<password>;H:false;;
 *
 * security: WPA / WEP / nopass
 */
private fun buildWifiQrPayload(
    ssid: String,
    password: String,
    security: String = "WPA",
    hidden: Boolean = false
): String {
    val s = escapeWifiQrValue(ssid)
    val p = escapeWifiQrValue(password)
    val h = if (hidden) "true" else "false"
    return "WIFI:T:$security;S:$s;P:$p;H:$h;;"
}

/**
 * Buat URL gambar QR dari layanan publik.
 * Tidak perlu library QR di APK.
 */
private fun buildQrUrl(data: String): String {
    val encoded = URLEncoder.encode(data, "UTF-8")
    return "https://api.qrserver.com/v1/create-qr-code/?size=300x300&data=$encoded"
}
