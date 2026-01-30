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

package com.karuhun.sync.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlin.reflect.KClass

@EntryPoint
@InstallIn(SingletonComponent::class)
interface HiltWorkerFactoryEntryPoint {
    fun hiltWorkerFactory(): HiltWorkerFactory
}


internal fun KClass<out CoroutineWorker>.delegatedData() =
    Data.Builder()
        .putString(WORKER_CLASS_NAME, qualifiedName)
        .build()

private const val WORKER_CLASS_NAME = "RouterWorkerDelegateClassName"

class DelegatingWorker(
    appContext: Context,
    workerParams: WorkerParameters,
) : CoroutineWorker(appContext, workerParams) {

    private val workerClassName =
        workerParams.inputData.getString(WORKER_CLASS_NAME) ?: ""

    private val delegateWorker: CoroutineWorker by lazy {
        try {
            val worker = EntryPointAccessors.fromApplication<HiltWorkerFactoryEntryPoint>(appContext)
                .hiltWorkerFactory()
                .createWorker(appContext, workerClassName, workerParams)

            when (worker) {
                is CoroutineWorker -> worker
                else -> {
                    Log.e("DelegatingWorker", "Created worker is not a CoroutineWorker: ${worker?.javaClass?.name}")
                    throw IllegalArgumentException("Unable to find appropriate worker: expected CoroutineWorker but got ${worker?.javaClass?.name}")
                }
            }
        } catch (e: Exception) {
            Log.e("DelegatingWorker", "Failed to create worker for class: $workerClassName", e)
            throw IllegalArgumentException("Unable to find appropriate worker for class: $workerClassName", e)
        }
    }

    override suspend fun getForegroundInfo(): ForegroundInfo =
        delegateWorker.getForegroundInfo()

    override suspend fun doWork(): Result = try {
        delegateWorker.doWork()
    } catch (e: Exception) {
        Log.e("DelegatingWorker", "doWork failed", e)
        Result.failure()
    }
}
