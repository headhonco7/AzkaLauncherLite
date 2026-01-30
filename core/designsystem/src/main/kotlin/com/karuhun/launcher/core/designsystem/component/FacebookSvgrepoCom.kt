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

package com.karuhun.launcher.core.designsystem.component

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FacebookSvgrepoCom: ImageVector
    get() {
        if (_FacebookSvgrepoCom != null) {
            return _FacebookSvgrepoCom!!
        }
        _FacebookSvgrepoCom = ImageVector.Builder(
            name = "FacebookSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(12f, 2.04f)
                curveTo(6.5f, 2.04f, 2f, 6.53f, 2f, 12.06f)
                curveTo(2f, 17.06f, 5.66f, 21.21f, 10.44f, 21.96f)
                verticalLineTo(14.96f)
                horizontalLineTo(7.9f)
                verticalLineTo(12.06f)
                horizontalLineTo(10.44f)
                verticalLineTo(9.85f)
                curveTo(10.44f, 7.34f, 11.93f, 5.96f, 14.22f, 5.96f)
                curveTo(15.31f, 5.96f, 16.45f, 6.15f, 16.45f, 6.15f)
                verticalLineTo(8.62f)
                horizontalLineTo(15.19f)
                curveTo(13.95f, 8.62f, 13.56f, 9.39f, 13.56f, 10.18f)
                verticalLineTo(12.06f)
                horizontalLineTo(16.34f)
                lineTo(15.89f, 14.96f)
                horizontalLineTo(13.56f)
                verticalLineTo(21.96f)
                curveTo(15.916f, 21.588f, 18.062f, 20.385f, 19.61f, 18.57f)
                curveTo(21.158f, 16.755f, 22.005f, 14.446f, 22f, 12.06f)
                curveTo(22f, 6.53f, 17.5f, 2.04f, 12f, 2.04f)
                close()
            }
        }.build()

        return _FacebookSvgrepoCom!!
    }

@Suppress("ObjectPropertyName")
private var _FacebookSvgrepoCom: ImageVector? = null
