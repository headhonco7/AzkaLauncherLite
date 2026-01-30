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

package com.karuhun.feature.restaurant.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karuhun.core.domain.usecase.GetFoodCategories
import com.karuhun.core.domain.usecase.GetFoodsUseCase
import com.karuhun.core.ui.navigation.delegate.mvi.MVI
import com.karuhun.core.ui.navigation.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RestaurantViewModel @Inject constructor(
    private val getFoodCategories: GetFoodCategories,
    private val getFoodsUseCase: GetFoodsUseCase
) : ViewModel(),
    MVI<RestaurantContract.UiState, RestaurantContract.UiAction, RestaurantContract.UiEffect> by mvi(
        initialState = RestaurantContract.UiState(),
    ) {

    init {
        onAction(RestaurantContract.UiAction.LoadCategory)
    }

    override fun onAction(action: RestaurantContract.UiAction) {
        when (action) {
            is RestaurantContract.UiAction.LoadCategory -> {
                loadCategory()
            }

            is RestaurantContract.UiAction.LoadFood -> {
                loadFood(action.categoryId)
            }
        }
    }

    private fun loadCategory() = viewModelScope.launch {
        getFoodCategories().collect {
            updateUiState {
                copy(
                    foodCategories = it
                )
            }
        }
    }

    private fun loadFood(categoryId: Int) = viewModelScope.launch {
        getFoodsUseCase(categoryId).collect {
            updateUiState {
                copy(
                    foods = it
                )
            }
        }
    }
}