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

import com.karuhun.core.domain.repository.ApplicationRepository
import com.karuhun.core.domain.repository.ContentItemsRepository
import com.karuhun.core.domain.repository.ContentRepository
import com.karuhun.feature.content.data.repository.ApplicationRepositoryImpl
import com.karuhun.feature.content.data.repository.ContentItemsRepositoryImpl
import com.karuhun.feature.content.data.repository.ContentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindContentRepository(
        impl: ContentRepositoryImpl,
    ): ContentRepository

    @Binds
    @Singleton
    abstract fun bindContentItemsRepository(
        impl: ContentItemsRepositoryImpl
    ): ContentItemsRepository

    @Binds
    @Singleton
    abstract fun bindApplicationRepository(
        impl: ApplicationRepositoryImpl
    ): ApplicationRepository
}