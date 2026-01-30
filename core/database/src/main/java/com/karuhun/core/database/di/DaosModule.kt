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

package com.karuhun.core.database.di

import com.karuhun.core.database.LauncherDatabase
import com.karuhun.core.database.dao.ContentDao
import com.karuhun.core.database.dao.HotelDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun provideHotelDao(
        database: LauncherDatabase
    ): HotelDao = database.hotelDao()

    @Provides
    fun provideContentDao(
        database: LauncherDatabase
    ): ContentDao = database.contentDao()

    @Provides
    fun provideApplicationDao(
        database: LauncherDatabase
    ) = database.applicationDao()

    @Provides
    fun provideContentItemDao(
        database: LauncherDatabase
    ) = database.contentItemDao()

    @Provides
    fun provideFoodCategoryDao(
        database: LauncherDatabase
    ) = database.foodCategoryDao()

    @Provides
    fun provideFoodDao(
        database: LauncherDatabase
    ) = database.foodDao()
}