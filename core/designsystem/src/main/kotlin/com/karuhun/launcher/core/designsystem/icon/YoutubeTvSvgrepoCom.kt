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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val YoutubeTvSvgrepoCom: ImageVector
    get() {
        if (_YoutubeTvSvgrepoCom != null) {
            return _YoutubeTvSvgrepoCom!!
        }
        _YoutubeTvSvgrepoCom = ImageVector.Builder(
            name = "YoutubeTvSvgrepoCom",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 48f,
            viewportHeight = 48f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12f, 39f)
                lineTo(36f, 39f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(6.5f, 9f)
                lineTo(41.5f, 9f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 43.5f, 11f)
                lineTo(43.5f, 33f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 41.5f, 35f)
                lineTo(6.5f, 35f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4.5f, 33f)
                lineTo(4.5f, 11f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6.5f, 9f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(29.86f, 22f)
                lineToRelative(-9.719f, -5.596f)
                lineToRelative(0f, 11.192f)
                lineToRelative(9.719f, -5.596f)
                close()
            }
        }.build()

        return _YoutubeTvSvgrepoCom!!
    }

@Suppress("ObjectPropertyName")
private var _YoutubeTvSvgrepoCom: ImageVector? = null
