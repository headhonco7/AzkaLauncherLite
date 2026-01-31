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

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeContract.UiState,
    uiAction: (HomeContract.UiAction) -> Unit,
    uiEffect: Flow<HomeContract.UiEffect>,
    onMenuItemClick: (String) -> Unit = { _ -> },
    onGoToMainMenu: () -> Unit,

    // ✅ v1.1: data WiFi dari config (default kosong biar tidak merusak pemanggil lama)
    wifiSsid: String = "",
    wifiPassword: String = "",

    // ✅ v1.1: data WhatsApp dari config (default kosong biar tidak merusak pemanggil lama)
    whatsappNumber: String = "",
    whatsappLabel: String = "",
) {
    // Overlay state (local UI state)
    var showWifiOverlay by remember { mutableStateOf(false) }
    var showWhatsappOverlay by remember { mutableStateOf(false) }

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is HomeContract.UiEffect.ShowError -> {
                // no-op for now
            }
        }
    }

    // ✅ Overlay WiFi (fullscreen)
    ZoomOverlay(
        visible = showWifiOverlay,
        title = "WiFi",
        onDismiss = { showWifiOverlay = false }
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
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

            Spacer(modifier = Modifier.height(6.dp))

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
        }
    }

    // ✅ Overlay WhatsApp (fullscreen)
    ZoomOverlay(
        visible = showWhatsappOverlay,
        title = if (whatsappLabel.isBlank()) "WhatsApp" else whatsappLabel,
        onDismiss = { showWhatsappOverlay = false }
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(
                text = "WhatsApp",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.80f)
            )
            Text(
                text = if (whatsappNumber.isBlank()) "Belum diisi" else whatsappNumber,
                fontSize = 22.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Catatan",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.80f)
            )
            Text(
                text = "Silakan chat untuk bantuan",
                fontSize = 18.sp,
                color = Color.White
            )
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

    // ✅ WiFi
    wifiSsid: String,
    onWifiClick: () -> Unit,

    // ✅ WhatsApp
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

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
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

        // ✅ WiFi card
        Spacer(modifier = Modifier.height(18.dp))
        WifiInfoCard(
            ssid = wifiSsid,
            onClick = onWifiClick,
            modifier = Modifier.fillMaxWidth()
        )

        // ✅ WhatsApp card
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
        Column(
            modifier = Modifier
                .width(320.dp)
        ) {
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

            whatsappNumber = "+62 851 22000 590",
            whatsappLabel = "Front Office",
        )
    }
}
