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

package com.karuhun.launcher

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.karuhun.core.common.util.DeviceUtil
import com.karuhun.launcher.core.designsystem.component.RunningText
import com.karuhun.launcher.core.designsystem.component.TopBar
import com.karuhun.launcher.core.designsystem.theme.AppTheme
import com.karuhun.launcher.data.ConfigRepository
import com.karuhun.navigation.MainAppNavGraph
import com.karuhun.navigation.OnboardingNavGraph
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Config state (class-level)
    private var loadedConfigJsonSource by mutableStateOf("loading")
    private var loadedPropertyName by mutableStateOf("")
    private var loadedWifiSsid by mutableStateOf("")
    private var loadedWhatsapp by mutableStateOf("")
    private var loadedRunningText by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load config (remote -> cache fallback)
        lifecycleScope.launch {
            try {
                val repo = ConfigRepository(this@MainActivity)
                val (cfg, source) = repo.getBestConfig()

                loadedConfigJsonSource = source
                loadedPropertyName = cfg.propertyName
                loadedWifiSsid = cfg.wifi.ssid
                loadedWhatsapp = cfg.whatsapp.number
                loadedRunningText = cfg.text.runningText

                Log.d(
                    "AZKA_CONFIG",
                    "source=$source name=${cfg.propertyName} wifi=${cfg.wifi.ssid}"
                )
            } catch (e: Exception) {
                loadedConfigJsonSource = "error"
                Log.e("AZKA_CONFIG", "Failed to load config", e)
            }
        }

        setContent {
            AppTheme {
                val viewModel = hiltViewModel<MainViewModel>()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                val navController = rememberNavController()

                if (uiState.isOnboardingCompleted) {
                    LauncherApplication(
                        modifier = Modifier.fillMaxSize(),
                        appState = rememberAppState(navController = navController),
                        uiState = uiState,
                        uiEffect = viewModel.uiEffect,
                        onAction = viewModel::onAction,
                        onMenuItemClick = {},
                        runningTextFromConfig = loadedRunningText,
                    )
                } else {
                    OnboardingNavGraph(
                        navController = navController,
                        onOnboardingComplete = {
                            viewModel.onAction(MainContract.UiAction.OnboardingCompleted)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LauncherApplication(
    modifier: Modifier = Modifier,
    appState: LauncherAppState,
    uiState: MainContract.UiState,
    uiEffect: Flow<MainContract.UiEffect>,
    onAction: (MainContract.UiAction) -> Unit,
    onMenuItemClick: (String) -> Unit,
    runningTextFromConfig: String,
) {
    Box(modifier = modifier) {

        // Background Image (fallback: hitam kalau kosong)
        AsyncImage(
            model = uiState.hotelProfile?.backgroundPhoto,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        // Dark overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)),
        )

        Column(modifier = Modifier.fillMaxSize()) {
            val formatter = remember { DateTimeFormatter.ofPattern("dd MMMM yyyy") }
            var formattedDate by remember { mutableStateOf(LocalDate.now().format(formatter)) }

            LaunchedEffect(Unit) {
                while (true) {
                    val newFormattedDate = LocalDate.now().format(formatter)
                    if (formattedDate != newFormattedDate) {
                        formattedDate = newFormattedDate
                    }
                    delay(1000L)
                }
            }

            TopBar(
                modifier = Modifier.height(80.dp),
                roomNumber = DeviceUtil.getDeviceName(LocalContext.current),
                date = formattedDate,
                temperature = "${uiState.weather?.temp?.toInt()}°C",
                imageUrl = uiState.hotelProfile?.logoWhite.orEmpty(),
                weatherText = uiState.weather?.icon.orEmpty()
            )

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 0.dp),
            ) {
                MainAppNavGraph(
                    modifier = Modifier.fillMaxSize(),
                    navController = appState.navController,
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            val running = if (runningTextFromConfig.isBlank()) {
                uiState.hotelProfile?.runningText.orEmpty()
            } else {
                runningTextFromConfig
            }

            RunningText(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .fillMaxWidth(),
                text = running,
            )
        }
    }
}

@Composable
@Preview(device = Devices.TV_1080p)
fun LauncherApplicationPreview() {
    // Preview: jangan pakai hiltViewModel(), cukup render layout dasar saja.
    // Karena LauncherApplication butuh LauncherAppState, kita cukup skip preview kompleks.
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        )
    }
}
