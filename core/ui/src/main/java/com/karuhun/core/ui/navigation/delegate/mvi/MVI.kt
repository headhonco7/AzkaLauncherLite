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

package com.karuhun.core.ui.navigation.delegate.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MVI<UiState, UIAction, UiEffect> {
    val uiState: StateFlow<UiState>
    val currentUiState: UiState
    val uiEffect: Flow<UiEffect>
    fun onAction(action: UIAction)
    fun updateUiState(block: UiState.() -> UiState)
    suspend fun emitUiEffect(uiEffect: UiEffect)
}

fun <UiState, UIAction, UiEffect> mvi(
    initialState: UiState,
) : MVI<UiState, UIAction, UiEffect> = MVIDelegate(initialState)