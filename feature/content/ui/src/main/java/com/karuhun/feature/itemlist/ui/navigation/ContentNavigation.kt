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

package com.karuhun.feature.itemlist.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.karuhun.core.model.Content
import com.karuhun.core.model.ContentItem
import com.karuhun.feature.itemlist.ui.ContentDetailScreen
import com.karuhun.feature.itemlist.ui.ContentItemsScreen
import com.karuhun.feature.itemlist.ui.ContentViewModel
import kotlinx.serialization.Serializable

@Serializable data class ContentItems(
    val id: Int,
    val name: String?,
    val image: String?,
)
@Serializable data class ContentDetail(
    val contentId: Int,
    val contentImage: String?,
    val contentTitle: String?,
    val contentDescription: String?,
)
fun NavGraphBuilder.contentScreen(
    onNavigateToDetail: (ContentItem) -> Unit,
) {
    composable<ContentItems> {
        val args: ContentItems = it.toRoute()
        val viewModel = hiltViewModel<ContentViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        val onAction = viewModel::onAction

        ContentItemsScreen(
            modifier = Modifier.fillMaxSize(),
            onNavigateToDetail = onNavigateToDetail,
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = onAction,
            content = Content(
                id = args.id,
                title = args.name,
                image = args.image,
                isActive = true,
            )
        )
    }
    composable<ContentDetail> {
        val args: ContentDetail = it.toRoute()
        val viewModel = hiltViewModel<ContentViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        val onAction = viewModel::onAction

        ContentDetailScreen(
            modifier = Modifier.fillMaxSize(),
            contentId = args.contentId,
            content = ContentItem(
                id = args.contentId,
                image = args.contentImage,
                description = args.contentDescription,
                name = args.contentTitle,
                contentId = args.contentId,
            ),
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = onAction,
        )
    }
}