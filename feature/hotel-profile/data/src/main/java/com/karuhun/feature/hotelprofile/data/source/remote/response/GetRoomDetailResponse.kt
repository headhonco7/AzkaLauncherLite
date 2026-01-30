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
import com.karuhun.core.model.RoomDetail

data class GetRoomDetailResponse(

	@field:SerializedName("guest_name")
	val guestName: String? = null,

	@field:SerializedName("greeting")
	val greeting: String? = null,

	@field:SerializedName("is_birthday")
	val isBirthday: Int? = null
)

fun GetRoomDetailResponse?.toDomain() = RoomDetail(
    guestName = this?.guestName.orEmpty(),
    greeting = this?.greeting,
    isBirthday = this?.isBirthday?.let { it == 1 }
)