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
import com.karuhun.core.model.Hotel

@Entity(
    tableName = "hotel"
)
data class HotelEntity(
    @PrimaryKey
    val id: Int? = 1,
    val name: String?,
    val phone: String?,
    val email: String?,
    val website: String?,
    val defaultGreeting: String?,
    val passwordSetting: String?,
    val logoWhite: String?,
    val logoBlack: String?,
    val primaryColor: String?,
    val mainPhoto: String?,
    val backgroundPhoto: String?,
    val introVideo: String?,
    val welcomeText: String?,
    val runningText: String?,
)

fun HotelEntity?.toDomain() = Hotel(
    name = this?.name.orEmpty(),
    phone = this?.phone,
    email = this?.email,
    website = this?.website,
    defaultGreeting = this?.defaultGreeting,
    passwordSetting = this?.passwordSetting,
    logoWhite = this?.logoWhite,
    logoBlack = this?.logoBlack,
    primaryColor = this?.primaryColor,
    mainPhoto = this?.mainPhoto,
    backgroundPhoto = this?.backgroundPhoto,
    introVideo = this?.introVideo,
    welcomeText = this?.welcomeText,
    runningText = this?.runningText,
)

fun Hotel.toEntity() = HotelEntity(
    name = name,
    phone = phone,
    email = email,
    website = website,
    defaultGreeting = defaultGreeting,
    passwordSetting = passwordSetting,
    logoWhite = logoWhite,
    logoBlack = logoBlack,
    primaryColor = primaryColor,
    mainPhoto = mainPhoto,
    backgroundPhoto = backgroundPhoto,
    introVideo = introVideo,
    welcomeText = welcomeText,
    runningText = runningText,
)
