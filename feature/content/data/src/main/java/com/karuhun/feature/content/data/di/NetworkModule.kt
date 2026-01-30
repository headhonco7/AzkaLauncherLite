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

package com.karuhun.feature.content.data.di

import com.karuhun.core.common.network.Dispatcher
import com.karuhun.core.common.network.LauncherDispatcher
import com.karuhun.feature.content.data.source.ApplicationApiService
import com.karuhun.feature.content.data.source.ContentApiService
import com.karuhun.feature.content.data.source.remote.ApplicationNetworkDataSource
import com.karuhun.feature.content.data.source.remote.ContentNetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideContentApiService(retrofit: Retrofit): ContentApiService =
        retrofit.create(ContentApiService::class.java)

    @Provides
    @Singleton
    fun provideApplicationApiService(retrofit: Retrofit): ApplicationApiService =
        retrofit.create(ApplicationApiService::class.java)

    @Provides
    @Singleton
    fun provideApplicationNetworkDataSource(
        apiService: ApplicationApiService,
        @Dispatcher(LauncherDispatcher.IO) ioDispatcher: CoroutineDispatcher
    ) : ApplicationNetworkDataSource{
        return ApplicationNetworkDataSource(
            apiService = apiService,
            ioDispatcher = ioDispatcher
        )
    }

    @Provides
    @Singleton
    fun provideContentNetworkDataSource(
        apiService: ContentApiService,
        @Dispatcher(LauncherDispatcher.IO) ioDispatcher: CoroutineDispatcher
    ) : ContentNetworkDataSource{
        return ContentNetworkDataSource(
            apiService = apiService,
            ioDispatcher = ioDispatcher
        )
    }
}