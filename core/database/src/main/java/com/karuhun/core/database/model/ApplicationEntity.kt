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
import com.karuhun.core.model.Application

@Entity(tableName = "application")
data class ApplicationEntity(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val image: String?,
    val packageName: String?,
)

fun ApplicationEntity.toDomain() = com.karuhun.core.model.Application(
    id = this.id ?: 0,
    name = this.name.orEmpty(),
    image = this.image.orEmpty(),
    packageName = this.packageName.orEmpty()
)

fun List<ApplicationEntity>.toDomainList(): List<com.karuhun.core.model.Application> {
    return this.map { it.toDomain() }
}

fun Application.toEntity() = ApplicationEntity(
    id = this.id ?: 0,
    name = this.name.orEmpty(),
    image = this.image.orEmpty(),
    packageName = this.packageName.orEmpty()
)

fun List<Application>.toEntityList(): List<ApplicationEntity> {
    return this.map { it.toEntity() }
}