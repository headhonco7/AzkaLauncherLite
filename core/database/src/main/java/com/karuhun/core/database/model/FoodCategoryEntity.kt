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
import com.karuhun.core.model.FoodCategory

@Entity(
    tableName = "food_category",
)
data class FoodCategoryEntity(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val description: String?,
    val image: String?
)

fun FoodCategoryEntity?.toDomain(): FoodCategory {
    return FoodCategory(
        id = this?.id,
        name = this?.name,
        description = this?.description,
        image = this?.image
    )
}

fun List<FoodCategoryEntity>?.toDomainList() : List<FoodCategory>? {
    return this?.map { it.toDomain() }
}

fun FoodCategory.toEntity(): FoodCategoryEntity =
    FoodCategoryEntity(
        id = id,
        name = name,
        description = description,
        image = image
    )

fun List<FoodCategory>.toEntityList(): List<FoodCategoryEntity> {
    return this.map { it.toEntity() }
}