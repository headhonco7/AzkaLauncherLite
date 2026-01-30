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

package com.karuhun.feature.home.ui.navigation

import androidx.annotation.Keep
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.karuhun.core.ui.navigation.Screen
import com.karuhun.feature.home.ui.HomeScreen
import com.karuhun.feature.home.ui.HomeViewModel
import kotlinx.serialization.Serializable

@Keep
@Serializable data object Home : Screen

fun NavGraphBuilder.homeScreen(
    onMenuItemClick: (String) -> Unit,
    onGoToMainMenu: () -> Unit,
){
    composable<Home> {
        val viewModel = hiltViewModel<HomeViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        val uiAction = viewModel::onAction
        HomeScreen(
            onMenuItemClick = onMenuItemClick,
            uiState = uiState,
            uiAction = uiAction,
            uiEffect = uiEffect,
            onGoToMainMenu = onGoToMainMenu,
        )
    }
}