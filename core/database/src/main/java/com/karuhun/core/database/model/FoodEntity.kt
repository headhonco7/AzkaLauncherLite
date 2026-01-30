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

package com.karuhun.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.karuhun.core.model.Food

@Entity(
    tableName = "foods",
)
data class FoodEntity(
    @PrimaryKey
    val id: Int,
	val image: String? = null,
	val updatedAt: String? = null,
	val foodCategoryId: Int? = null,
	val price: Int? = null,
	val hotelId: Int? = null,
	val name: String? = null,
	val description: String? = null,
	val createdAt: String? = null,
)

fun FoodEntity.toDomain(): Food {
    return Food(
        id = id,
        name = name,
        description = description,
        price = price,
        imageUrl = image,
        categoryId = foodCategoryId,
        isDeleted = false
    )
}

fun List<FoodEntity>.toDomainList(): List<Food> {
    return this.map { it.toDomain() }
}

fun Food.toDomain(): FoodEntity =
    FoodEntity(
        id = id,
        name = name,
        image = imageUrl,
        price = price,
        foodCategoryId = categoryId,
        description = description
    )

fun List<Food>.toEntityList(): List<FoodEntity> {
    return this.map { it.toDomain() }
}