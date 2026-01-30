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

package com.karuhun.feature.content.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.karuhun.core.common.orZero
import com.karuhun.core.model.Application

data class GetApplicationsResponse(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("hotel_id")
	val hotelId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("package_name")
	val packageName: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

fun GetApplicationsResponse?.toDomain() = Application(
    id = this?.id.orZero(),
    name = this?.name.orEmpty(),
    image = this?.image.orEmpty(),
    packageName = this?.packageName.orEmpty()
)

fun List<GetApplicationsResponse>?.toDomainList(): List<Application> {
    return this?.map { it.toDomain() } ?: emptyList()
}