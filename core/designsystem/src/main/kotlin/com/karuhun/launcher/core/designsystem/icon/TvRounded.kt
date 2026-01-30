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

val TvRounded: ImageVector
    get() {
        if (_TvRounded != null) {
            return _TvRounded!!
        }
        _TvRounded = ImageVector.Builder(
            name = "TvRounded",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(26f, 27.25f)
                horizontalLineToRelative(-20f)
                curveToRelative(-0.414f, 0f, -0.75f, 0.336f, -0.75f, 0.75f)
                reflectiveCurveToRelative(0.336f, 0.75f, 0.75f, 0.75f)
                verticalLineToRelative(0f)
                horizontalLineToRelative(20f)
                curveToRelative(0.414f, 0f, 0.75f, -0.336f, 0.75f, -0.75f)
                reflectiveCurveToRelative(-0.336f, -0.75f, -0.75f, -0.75f)
                verticalLineToRelative(0f)
                close()
                moveTo(28f, 3.25f)
                horizontalLineToRelative(-24f)
                curveToRelative(-1.518f, 0.002f, -2.748f, 1.232f, -2.75f, 2.75f)
                verticalLineToRelative(16f)
                curveToRelative(0.002f, 1.518f, 1.232f, 2.748f, 2.75f, 2.75f)
                horizontalLineToRelative(24f)
                curveToRelative(1.518f, -0.002f, 2.748f, -1.232f, 2.75f, -2.75f)
                verticalLineToRelative(-16f)
                curveToRelative(-0.002f, -1.518f, -1.232f, -2.748f, -2.75f, -2.75f)
                horizontalLineToRelative(-0f)
                close()
                moveTo(29.25f, 22f)
                curveToRelative(-0.001f, 0.69f, -0.56f, 1.249f, -1.25f, 1.25f)
                horizontalLineToRelative(-24f)
                curveToRelative(-0.69f, -0.001f, -1.249f, -0.56f, -1.25f, -1.25f)
                verticalLineToRelative(-16f)
                curveToRelative(0.001f, -0.69f, 0.56f, -1.249f, 1.25f, -1.25f)
                horizontalLineToRelative(24f)
                curveToRelative(0.69f, 0.001f, 1.249f, 0.56f, 1.25f, 1.25f)
                verticalLineToRelative(0f)
                close()
            }
        }.build()

        return _TvRounded!!
    }

@Suppress("ObjectPropertyName")
private var _TvRounded: ImageVector? = null
