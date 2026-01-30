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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val WifiSvgrepoCom: ImageVector
    get() {
        if (_WifiSvgrepoCom != null) {
            return _WifiSvgrepoCom!!
        }
        _WifiSvgrepoCom = ImageVector.Builder(
            name = "WifiSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(30.765f, 28.616f)
                arcTo(10.516f, 10.516f, 0f, isMoreThanHalf = false, isPositiveArc = false, 17.33f, 28.579f)
                verticalLineToRelative(0.036f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(24.021f, 32.921f)
                arcToRelative(4.216f, 4.216f, 0f, isMoreThanHalf = true, isPositiveArc = false, 4.216f, 4.216f)
                horizontalLineToRelative(0f)
                arcToRelative(4.216f, 4.216f, 0f, isMoreThanHalf = false, isPositiveArc = false, -4.216f, -4.216f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(37.178f, 21.326f)
                arcToRelative(20.676f, 20.676f, 0f, isMoreThanHalf = false, isPositiveArc = false, -26.315f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(43.5f, 13.674f)
                arcToRelative(30.568f, 30.568f, 0f, isMoreThanHalf = false, isPositiveArc = false, -39f, 0f)
            }
        }.build()

        return _WifiSvgrepoCom!!
    }

@Suppress("ObjectPropertyName")
private var _WifiSvgrepoCom: ImageVector? = null
