package com.karuhun.launcher.core.designsystem.component

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import androidx.tv.material3.Text

/**
 * Overlay fullscreen sederhana untuk TV/STB.
 * - Dim background
 * - Panel tengah
 * - Bisa ditutup via BACK (remote)
 */
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ZoomOverlay(
    visible: Boolean,
    title: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    if (!visible) return

    // Tombol BACK di remote untuk menutup overlay
    BackHandler(enabled = true) {
        onDismiss()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.70f)),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            shape = RoundedCornerShape(18.dp),
            modifier = Modifier
                .widthIn(min = 520.dp, max = 920.dp)
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Column(
                modifier = Modifier.padding(22.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = title,
                    fontSize = 22.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 10.dp))

                // Isi overlay (kita isi di langkah berikutnya: WiFi detail + QR)
                content()

                Spacer(modifier = Modifier.padding(top = 14.dp))

                Text(
                    text = "Tekan BACK untuk menutup",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.75f)
                )
            }
        }
    }
}
