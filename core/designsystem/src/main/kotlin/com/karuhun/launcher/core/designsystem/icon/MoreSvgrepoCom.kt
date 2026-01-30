/*
 * Copyright 2025 The Android Open Source Project
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

package com.karuhun.launcher.core.designsystem.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val MoreSvgrepoCom: ImageVector
    get() {
        if (_MoreSvgrepoCom != null) {
            return _MoreSvgrepoCom!!
        }
        _MoreSvgrepoCom = ImageVector.Builder(
            name = "MoreSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 1024f,
            viewportHeight = 1024f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(642.2f, 504.6f)
                curveToRelative(8f, 7.2f, 7.9f, 17.6f, -0.3f, 24.8f)
                lineTo(332.6f, 799.9f)
                curveToRelative(-8.9f, 7.8f, -9.8f, 21.2f, -2f, 30.1f)
                curveToRelative(7.8f, 8.9f, 21.2f, 9.8f, 30.1f, 2f)
                lineToRelative(309.2f, -270.6f)
                curveToRelative(27.4f, -24f, 27.8f, -64.1f, 0.9f, -88.5f)
                lineTo(361f, 192.2f)
                curveToRelative(-8.7f, -7.9f, -22.2f, -7.2f, -30.1f, 1.5f)
                curveToRelative(-7.9f, 8.7f, -7.2f, 22.2f, 1.5f, 30.1f)
                lineToRelative(309.8f, 280.8f)
                close()
            }
        }.build()

        return _MoreSvgrepoCom!!
    }

@Suppress("ObjectPropertyName")
private var _MoreSvgrepoCom: ImageVector? = null
