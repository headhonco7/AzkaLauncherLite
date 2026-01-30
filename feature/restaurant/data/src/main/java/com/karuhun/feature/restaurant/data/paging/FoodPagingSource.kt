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

package com.karuhun.feature.restaurant.data.paging

import com.karuhun.core.common.BasePagingSource
import com.karuhun.core.common.orZero
import com.karuhun.core.database.model.FoodCategoryEntity
import com.karuhun.core.database.model.FoodEntity
import com.karuhun.core.network.model.BaseResponse
import com.karuhun.feature.restaurant.data.source.RestaurantApiService
import com.karuhun.feature.restaurant.data.source.remote.response.GetCategoryResponse
import com.karuhun.feature.restaurant.data.source.remote.response.GetFoodsResponse

internal class FoodPagingSource(
    private val restaurantApiService: RestaurantApiService
) : BasePagingSource<FoodEntity, GetFoodsResponse>() {

    override suspend fun fetchData(page: Int, pageSize: Int): List<GetFoodsResponse> {
        val params = mutableMapOf<String, String>().apply {
            put("paginate", pageSize.toString())
            put("page", page.toString())
        }

        val response = restaurantApiService.getFoods(params)
        return response.data?.data ?: emptyList()
    }

    override fun mapToLocalData(remoteData: List<GetFoodsResponse>): List<FoodEntity> {
        return remoteData.map { response ->
            FoodEntity(
                id = response.id.orZero(),
                name = response.name,
                description = response.description,
                image = response.image,
                foodCategoryId = response.foodCategoryId
            )
        }
    }
}
