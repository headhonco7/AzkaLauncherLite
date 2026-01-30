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

package com.karuhun.feature.itemlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karuhun.core.common.orZero
import com.karuhun.core.domain.usecase.GetContentItemsUseCase
import com.karuhun.core.domain.usecase.GetContentsUseCase
import com.karuhun.core.ui.navigation.delegate.mvi.MVI
import com.karuhun.core.ui.navigation.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ContentViewModel @Inject constructor(
    private val getContentItemsUseCase: GetContentItemsUseCase,
) : ViewModel(),
    MVI<ContentContract.UiState, ContentContract.UiAction, ContentContract.UiEffect> by mvi(
        initialState = ContentContract.UiState(),
    ) {

    override fun onAction(action: ContentContract.UiAction) {
        when (action) {
            is ContentContract.UiAction.LoadContents -> {
                loadContents(action.contentId)
            }
        }
    }

    private fun loadContents(contentId: Int) = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        getContentItemsUseCase(contentId).collect {
            updateUiState {
                copy(
                    isLoading = false,
                    contents = it,
                )
            }
        }
    }
}