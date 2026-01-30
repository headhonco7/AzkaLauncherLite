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

package com.karuhun.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.karuhun.core.common.network.Dispatcher
import com.karuhun.core.common.network.LauncherDispatcher
import com.karuhun.core.common.network.di.ApplicationScope
import com.karuhun.core.datastore.Hotel
import com.karuhun.core.datastore.HotelProfile
import com.karuhun.core.datastore.HotelProfileSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton
import com.karuhun.core.datastore.Version
import com.karuhun.core.datastore.VersionSerializer

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun provideVersionPreferencesDataStore(
        @ApplicationContext context: Context,
        @Dispatcher(LauncherDispatcher.IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
        versionSerializer: VersionSerializer
    ): DataStore<Version> =
        DataStoreFactory.create(
            serializer = versionSerializer,
            scope = scope,
        ) {
            context.dataStoreFile("version.pb")
        }

    @Provides
    @Singleton
    fun provideHotelProfileDataStore(
        @ApplicationContext context: Context,
        @Dispatcher(LauncherDispatcher.IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
        hotelProfileSerializer: HotelProfileSerializer
    ): DataStore<Hotel> =
        DataStoreFactory.create(
            serializer = hotelProfileSerializer,
            scope = scope,
        ) {
            context.dataStoreFile("hotel_profile.pb")
        }
}