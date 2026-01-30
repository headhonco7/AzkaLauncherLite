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

val DisneySvgrepoCom: ImageVector
    get() {
        if (_DisneySvgrepoCom != null) {
            return _DisneySvgrepoCom!!
        }
        _DisneySvgrepoCom = ImageVector.Builder(
            name = "DisneySvgrepoCom",
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
                moveTo(7f, 11.15f)
                curveTo(4.32f, 10.85f, 4.5f, 10f, 4.5f, 9.57f)
                reflectiveCurveToRelative(0.87f, -2.08f, 8.91f, -2.08f)
                curveToRelative(9.63f, 0f, 30.09f, 7.26f, 30.09f, 20f)
                reflectiveCurveToRelative(-17.88f, 9.82f, -21.42f, 9f)
                reflectiveCurveTo(9.85f, 32f, 9.85f, 28.18f)
                curveToRelative(0f, -2.78f, 7.13f, -4.35f, 14.59f, -4.35f)
                reflectiveCurveToRelative(10f, 2.09f, 10f, 4f)
                curveToRelative(0f, 0.84f, -0.4f, 1.84f, -2.3f, 2.38f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(21.66f, 15.3f)
                arcToRelative(190.17f, 190.17f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, 25.21f)
            }
        }.build()

        return _DisneySvgrepoCom!!
    }

@Suppress("ObjectPropertyName")
private var _DisneySvgrepoCom: ImageVector? = null
