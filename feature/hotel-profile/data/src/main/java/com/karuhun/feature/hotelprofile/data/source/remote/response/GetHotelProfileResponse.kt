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

package com.karuhun.feature.hotelprofile.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.karuhun.core.model.Hotel

data class GetHotelProfileResponse(

    @field:SerializedName("password_setting")
    val passwordSetting: String? = null,

    @field:SerializedName("website")
    val website: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("is_active")
    val isActive: Int? = null,

    @field:SerializedName("profile")
    val profile: Profile? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("branch")
    val branch: String? = null,

    @field:SerializedName("default_greeting")
    val defaultGreeting: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("user_id")
    val userId: Any? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,
)

data class Profile(

    @field:SerializedName("logo_black")
    val logoBlack: String? = null,

    @field:SerializedName("hotel_id")
    val hotelId: Int? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("primary_color")
    val primaryColor: String? = null,

    @field:SerializedName("intro_video")
    val introVideo: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("logo_color")
    val logoColor: String? = null,

    @field:SerializedName("running_text")
    val runningText: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("logo_white")
    val logoWhite: String? = null,

    @field:SerializedName("background_photo")
    val backgroundPhoto: String? = null,

    @field:SerializedName("main_photo")
    val mainPhoto: String? = null,

    @field:SerializedName("welcome_text")
    val welcomeText: String? = null,
)

fun GetHotelProfileResponse?.toDomain() = Hotel(
    id = this?.id,
    name = this?.name,
    phone = this?.phone,
    email = this?.email,
    website = this?.website,
    defaultGreeting = this?.defaultGreeting,
    passwordSetting = this?.passwordSetting,
    logoWhite = this?.profile?.logoWhite,
    logoBlack = this?.profile?.logoBlack,
    primaryColor = this?.profile?.primaryColor,
    mainPhoto = this?.profile?.mainPhoto,
    backgroundPhoto = this?.profile?.backgroundPhoto,
    introVideo = this?.profile?.introVideo,
    welcomeText = this?.profile?.welcomeText,
    runningText = this?.profile?.runningText,
)