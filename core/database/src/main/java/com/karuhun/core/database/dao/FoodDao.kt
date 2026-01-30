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

package com.karuhun.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.karuhun.core.database.model.FoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM foods")
    fun getAll(): Flow<List<FoodEntity>>

    @Query("SELECT * FROM foods WHERE id = :id")
    fun getById(id: Int): Flow<FoodEntity?>

    @Query("SELECT * FROM foods WHERE foodCategoryId = :foodCategoryId")
    fun getByCategoryId(foodCategoryId: Int): Flow<List<FoodEntity>>

    @Query("DELETE FROM foods WHERE foodCategoryId = :foodCategoryId")
    suspend fun deleteByCategoryId(foodCategoryId: Int)

    @Query("DELETE FROM foods")
    suspend fun deleteAll()

    @Upsert
    suspend fun upsert(food: List<FoodEntity>)

    @Query("DELETE FROM foods where id in (:ids)")
    suspend fun delete(ids: List<Int>)

    @Query("DELETE FROM foods WHERE id in (:ids)")
    suspend fun deleteById(ids: List<Int>)
}