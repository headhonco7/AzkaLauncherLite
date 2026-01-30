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

package com.karuhun.launcher.core.designsystem.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ArroundUs: ImageVector
    get() {
        if (_ArroundUs != null) {
            return _ArroundUs!!
        }
        _ArroundUs = ImageVector.Builder(
            name = "ArroundUs",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(20f, 23.003f)
                lineTo(19.497f, 23f)
                curveTo(12.59f, 22.958f, 1f, 22.514f, 1f, 20f)
                curveToRelative(0f, -1.09f, 1.756f, -1.416f, 4.187f, -1.866f)
                curveToRelative(1.193f, -0.22f, 3.677f, -0.682f, 3.814f, -1.138f)
                curveToRelative(-0.116f, -0.368f, -2.117f, -0.889f, -4.523f, -0.997f)
                lineTo(4f, 15.979f)
                lineTo(4f, 15f)
                lineToRelative(1f, 0.026f)
                curveToRelative(2.06f, 0.128f, 5f, 0.56f, 5f, 1.974f)
                curveToRelative(0f, 1.259f, -2.146f, 1.656f, -4.632f, 2.117f)
                curveToRelative(-1.18f, 0.219f, -3.153f, 0.584f, -3.382f, 0.94f)
                curveToRelative(0.309f, 0.97f, 8.324f, 1.887f, 17.515f, 1.943f)
                lineTo(20f, 22f)
                close()
                moveTo(9f, 5.133f)
                curveTo(9f, 7.412f, 6.814f, 10.5f, 5f, 14f)
                curveToRelative(-1.814f, -3.5f, -4f, -6.587f, -4f, -8.868f)
                arcTo(4.04f, 4.04f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5f, 1f)
                arcToRelative(4.04f, 4.04f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4f, 4.132f)
                close()
                moveTo(5.565f, 10.885f)
                curveTo(6.817f, 8.66f, 8f, 6.562f, 8f, 5.132f)
                arcTo(3.035f, 3.035f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5f, 2f)
                arcToRelative(3.035f, 3.035f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3f, 3.132f)
                curveToRelative(0f, 1.43f, 1.183f, 3.53f, 2.435f, 5.753f)
                curveToRelative(0.186f, 0.332f, 0.376f, 0.668f, 0.565f, 1.01f)
                curveToRelative(0.19f, -0.342f, 0.379f, -0.678f, 0.565f, -1.01f)
                close()
                moveTo(7f, 5f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, -2f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2f, 2f)
                close()
                moveTo(6f, 5f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = false, -1f, 1f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                close()
                moveTo(23f, 12.132f)
                curveToRelative(0f, 2.281f, -2.186f, 5.368f, -4f, 8.868f)
                curveToRelative(-1.814f, -3.5f, -4f, -6.587f, -4f, -8.868f)
                arcToRelative(4.002f, 4.002f, 0f, isMoreThanHalf = true, isPositiveArc = true, 8f, 0f)
                close()
                moveTo(19.565f, 17.885f)
                curveTo(20.817f, 15.66f, 22f, 13.562f, 22f, 12.132f)
                arcToRelative(3.003f, 3.003f, 0f, isMoreThanHalf = true, isPositiveArc = false, -6f, 0f)
                curveToRelative(0f, 1.43f, 1.183f, 3.53f, 2.435f, 5.753f)
                curveToRelative(0.186f, 0.332f, 0.376f, 0.668f, 0.565f, 1.01f)
                curveToRelative(0.19f, -0.342f, 0.379f, -0.678f, 0.565f, -1.01f)
                close()
                moveTo(21f, 12f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = true, isPositiveArc = true, -2f, -2f)
                arcToRelative(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2f, 2f)
                close()
                moveTo(20f, 12f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = true, isPositiveArc = false, -1f, 1f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                close()
            }
        }.build()

        return _ArroundUs!!
    }

@Suppress("ObjectPropertyName")
private var _ArroundUs: ImageVector? = null
