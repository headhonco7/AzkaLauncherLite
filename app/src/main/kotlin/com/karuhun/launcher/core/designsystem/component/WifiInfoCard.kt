package com.karuhun.launcher.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices.TV_1080p
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.karuhun.launcher.core.designsystem.theme.AppTheme

/**
 * Kartu WiFi untuk Home.
 * - Focusable + clickable (remote OK)
 * - Menampilkan SSID (password tidak ditampilkan di kartu)
 * - Nanti akan dipakai untuk membuka ZoomOverlay
 */
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun WifiInfoCard(
    ssid: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(18.dp)

    Surface(
        onClick = onClick,
        shape = shape,
        modifier = modifier
            .widthIn(min = 420.dp, max = 720.dp)
            .clip(shape)
            .background(Color.Black.copy(alpha = 0.35f))
            .border(
                width = 1.dp,
                color = Color.White.copy(alpha = 0.20f),
                shape = shape
            )
            .padding(16.dp),
        contentColor = Color.White
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "WiFi",
                fontSize = 20.sp,
                color = Color.White
            )

            Text(
                text = if (ssid.isBlank()) "SSID belum diisi" else ssid,
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.95f)
            )

            Text(
                text = "Tekan OK untuk lihat detail",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.75f)
            )
        }
    }
}

@Preview(device = TV_1080p, showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun WifiInfoCardPreview() {
    AppTheme {
        WifiInfoCard(
            ssid = "De AZKA WiFi",
            onClick = {},
            modifier = Modifier.padding(PaddingValues(16.dp))
        )
    }
}
