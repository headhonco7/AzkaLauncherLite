package com.karuhun.launcher.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.tooling.preview.Devices.TV_1080p
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.karuhun.launcher.core.designsystem.theme.AppTheme

/**
 * Overlay fullscreen sederhana untuk TV:
 * - visible=false -> tidak render apapun
 * - klik area gelap atau tekan BACK -> dismiss
 */
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ZoomOverlay(
    visible: Boolean,
    title: String,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit,
) {
    if (!visible) return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.72f))
            .clickable { onDismiss() }
            .onKeyEvent { event ->
                if (event.key == Key.Back) {
                    onDismiss()
                    true
                } else {
                    false
                }
            },
        contentAlignment = Alignment.Center
    ) {
        // Card overlay (klik di dalam tidak menutup)
        Column(
            modifier = Modifier
                .widthIn(min = 520.dp, max = 880.dp)
                .clip(RoundedCornerShape(22.dp))
                .background(Color.Black.copy(alpha = 0.78f))
                .clickable(enabled = true) { /* consume click */ }
                .padding(22.dp)
        ) {
            Text(
                text = title,
                fontSize = 22.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 14.dp)
            )
            content()
        }
    }
}

@Preview(device = TV_1080p, showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun ZoomOverlayPreview() {
    AppTheme {
        ZoomOverlay(
            visible = true,
            title = "Preview Overlay",
            onDismiss = {}
        ) {
            Text(text = "Isi overlay di sini", color = Color.White)
        }
    }
}
