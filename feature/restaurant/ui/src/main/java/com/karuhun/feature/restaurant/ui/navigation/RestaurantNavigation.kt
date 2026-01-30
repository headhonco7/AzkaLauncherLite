/*
 * Copyright 2025 The Karuhun Developer
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

package com.karuhun.feature.restaurant.ui.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.karuhun.feature.restaurant.ui.RestaurantCategoryScreen
import com.karuhun.feature.restaurant.ui.RestaurantViewModel
import kotlinx.serialization.Serializable

@Serializable
data object RestaurantCategory

fun NavGraphBuilder.restaurantGraph(

) {
    composable<RestaurantCategory> {
        val viewModel = hiltViewModel<RestaurantViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        val onAction = viewModel::onAction
        RestaurantCategoryScreen(
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = onAction
        )
    }
}