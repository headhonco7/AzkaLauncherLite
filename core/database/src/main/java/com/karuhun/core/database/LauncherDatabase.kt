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

package com.karuhun.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karuhun.core.database.dao.ApplicationDao
import com.karuhun.core.database.dao.ContentDao
import com.karuhun.core.database.dao.ContentItemDao
import com.karuhun.core.database.dao.HotelDao
import com.karuhun.core.database.dao.FoodCategoryDao
import com.karuhun.core.database.dao.FoodDao
import com.karuhun.core.database.model.ApplicationEntity
import com.karuhun.core.database.model.ContentEntity
import com.karuhun.core.database.model.ContentItemEntity
import com.karuhun.core.database.model.HotelEntity
import com.karuhun.core.database.model.FoodCategoryEntity
import com.karuhun.core.database.model.FoodEntity

@Database(
    entities = [
        HotelEntity::class,
        ContentEntity::class,
        ContentItemEntity::class,
        ApplicationEntity::class,
        FoodCategoryEntity::class,
        FoodEntity::class
    ],
    version = 1
)
abstract class LauncherDatabase : RoomDatabase() {
    abstract fun hotelDao() : HotelDao
    abstract fun contentDao(): ContentDao
    abstract fun applicationDao(): ApplicationDao
    abstract fun contentItemDao(): ContentItemDao
    abstract fun foodCategoryDao(): FoodCategoryDao
    abstract fun foodDao(): FoodDao
}