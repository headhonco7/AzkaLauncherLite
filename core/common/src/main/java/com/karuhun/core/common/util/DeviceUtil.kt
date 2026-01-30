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

package com.karuhun.core.common.util

import android.content.Context
import android.os.Build
import android.provider.Settings
import androidx.core.os.EnvironmentCompat

object DeviceUtil {
    fun getDeviceName(context: Context): String {
        return try {
            val deviceName = Settings.Global.getString(context.contentResolver, "device_name")
            when {
                deviceName != null -> deviceName
                Build.VERSION.SDK_INT > 31 -> EnvironmentCompat.MEDIA_UNKNOWN
                else -> Settings.Secure.getString(context.contentResolver, "bluetooth_name") ?: EnvironmentCompat.MEDIA_UNKNOWN
            }
        } catch (e: Exception) {
            EnvironmentCompat.MEDIA_UNKNOWN
        }
    }
}