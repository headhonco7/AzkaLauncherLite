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

package com.karuhun.core.common

sealed class Resource<out T> {
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val exception: BaseException) : Resource<Nothing>()
}

inline fun <T> Resource<T>.onSuccess(action: (T) -> Unit): Resource<T> {
    if (this is Resource.Success) action(data)
    return this
}

inline fun <T> Resource<T>.onFailure(action: (BaseException) -> Unit): Resource<T> {
    if (this is Resource.Error) action(exception)
    return this
}

inline fun <T, R : Any> Resource<T>.map(transform: (T) -> R): Resource<R> {
    return when (this) {
        is Resource.Success -> Resource.Success(transform(data))
        is Resource.Error -> Resource.Error(exception)
    }
}

inline fun <T> Resource<T>.fold(
    onSuccess: (T) -> Unit,
    onError: (BaseException) -> Unit,
) {
    when (this) {
        is Resource.Success -> onSuccess(data)
        is Resource.Error -> onError(exception)
    }
}

fun <T> Resource<T>.toUnit(): Resource<Unit> {
    return when (this) {
        is Resource.Success -> Resource.Success(Unit)
        is Resource.Error -> Resource.Error(exception)
    }
}

fun <T> Resource<T>.toModel(): T? {
    return when (this) {
        is Resource.Success -> data
        is Resource.Error -> null
    }
}