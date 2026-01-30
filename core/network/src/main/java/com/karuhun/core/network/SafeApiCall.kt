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

package com.karuhun.core.network

import com.karuhun.core.common.AuthorizationException
import com.karuhun.core.common.BadRequestException
import com.karuhun.core.common.NetworkException
import com.karuhun.core.common.NotFoundException
import com.karuhun.core.common.Resource
import com.karuhun.core.common.UnknownException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import retrofit2.HttpException
import java.io.IOException

suspend fun <T : Any> safeApiCall(apiToBeCalled: suspend () -> T): Resource<T> {
    return withContext(Dispatchers.IO) {
        try {
            Resource.Success(apiToBeCalled())
        } catch (e: HttpException) {
            val message = Json.parseToJsonElement(
                e.response()?.errorBody()?.string().orEmpty()
            ).jsonObject["message"]?.jsonPrimitive?.content.orEmpty().ifEmpty {
                "An unknown error occurred, please try again later."
            }
            when(e.code()) {
                400 -> Resource.Error(BadRequestException(message))
                401 -> Resource.Error(AuthorizationException(message))
                404 -> Resource.Error(NotFoundException(message))
                else -> Resource.Error(UnknownException(message))
            }
        } catch (e: IOException) {
            Resource.Error(NetworkException())
        } catch (e: Exception) {
            Resource.Error(UnknownException())
        }
    }
}