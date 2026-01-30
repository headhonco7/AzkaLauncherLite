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

package com.karuhun.sync.initializer

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.karuhun.sync.worker.SyncWorker

object Sync {
    fun initialize(context: Context) {
        WorkManager.getInstance(context).apply {
            enqueueUniqueWork(
                uniqueWorkName = SYNC_WORK_NAME,
                existingWorkPolicy = ExistingWorkPolicy.KEEP,
                request = SyncWorker.startUpSyncWork(),
            )
        }
    }
}

internal const val SYNC_WORK_NAME = "SyncWork"