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

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlin.getValue

class MVIDelegate<UiState, UIAction, UiEffect>(
    initialState: UiState,
) : MVI<UiState, UIAction, UiEffect> {

    private val _uiState by lazy { MutableStateFlow(initialState) }
    override val uiState: StateFlow<UiState> by lazy { _uiState.asStateFlow() }

    override val currentUiState: UiState
        get() = uiState.value

    private val _uiEffect by lazy { Channel<UiEffect>() }
    override val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    override fun onAction(action: UIAction) = Unit

    override fun updateUiState(block: UiState.() -> UiState) =
        _uiState.update(block)

    override suspend fun emitUiEffect(uiEffect: UiEffect) =
        _uiEffect.send(uiEffect)
}