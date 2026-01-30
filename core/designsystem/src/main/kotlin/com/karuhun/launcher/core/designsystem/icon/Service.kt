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

val Service: ImageVector
    get() {
        if (_Service != null) {
            return _Service!!
        }
        _Service = ImageVector.Builder(
            name = "Service",
            defaultWidth = 800.dp,
            defaultHeight = 800.dp,
            viewportWidth = 1024f,
            viewportHeight = 1024f
        ).apply {
            path(fill = SolidColor(Color(0xFF666666))) {
                moveTo(484f, 1008.8f)
                lineTo(480f, 1008.8f)
                curveToRelative(-33.6f, -1.6f, -63.2f, -25.6f, -72f, -59.2f)
                curveToRelative(-10.4f, -40f, 10.4f, -80.8f, 49.6f, -95.2f)
                curveToRelative(8.8f, -3.2f, 18.4f, -4.8f, 27.2f, -4.8f)
                curveToRelative(30.4f, 0f, 58.4f, 17.6f, 71.2f, 44.8f)
                curveToRelative(3.2f, 6.4f, 7.2f, 7.2f, 9.6f, 7.2f)
                horizontalLineToRelative(3.2f)
                curveToRelative(135.2f, -22.4f, 235.2f, -96f, 297.6f, -218.4f)
                curveToRelative(0.8f, -0.8f, 0.8f, -2.4f, 1.6f, -4f)
                lineToRelative(2.4f, -6.4f)
                lineToRelative(-7.2f, 0.8f)
                lineToRelative(-4.8f, 0.8f)
                curveToRelative(-3.2f, 0f, -4.8f, 0.8f, -7.2f, 0.8f)
                horizontalLineToRelative(-6.4f)
                curveToRelative(-59.2f, 0f, -107.2f, -48f, -107.2f, -107.2f)
                lineTo(737.6f, 457.6f)
                curveToRelative(0f, -59.2f, 48f, -107.2f, 107.2f, -107.2f)
                horizontalLineToRelative(6.4f)
                curveToRelative(7.2f, 0f, 13.6f, 2.4f, 20.8f, 4f)
                curveToRelative(3.2f, 0.8f, 7.2f, 1.6f, 10.4f, 2.4f)
                lineToRelative(2.4f, 0.8f)
                lineToRelative(6.4f, 2.4f)
                lineToRelative(-1.6f, -7.2f)
                curveTo(856f, 212f, 718.4f, 68f, 522.4f, 63.2f)
                lineTo(512f, 63.2f)
                curveToRelative(-200f, 0f, -341.6f, 144.8f, -378.4f, 288f)
                lineToRelative(-1.6f, 6.4f)
                lineToRelative(6.4f, -1.6f)
                curveToRelative(2.4f, -0.8f, 4.8f, -0.8f, 7.2f, -1.6f)
                curveToRelative(5.6f, -1.6f, 10.4f, -3.2f, 16f, -4f)
                curveToRelative(5.6f, -0.8f, 12f, -1.6f, 17.6f, -1.6f)
                curveToRelative(50.4f, 0f, 96.8f, 38.4f, 104.8f, 88f)
                curveToRelative(0.8f, 6.4f, 1.6f, 14.4f, 1.6f, 22.4f)
                verticalLineToRelative(108f)
                curveToRelative(0f, 52f, -34.4f, 94.4f, -85.6f, 105.6f)
                curveToRelative(-7.2f, 1.6f, -14.4f, 2.4f, -21.6f, 2.4f)
                curveToRelative(-52f, 0f, -96.8f, -38.4f, -105.6f, -88.8f)
                curveToRelative(-0.8f, -7.2f, -1.6f, -12.8f, -1.6f, -18.4f)
                verticalLineToRelative(-32f)
                curveToRelative(0f, -28f, -0.8f, -56.8f, 0f, -84.8f)
                curveToRelative(3.2f, -140.8f, 61.6f, -256.8f, 172f, -344f)
                curveToRelative(55.2f, -44f, 120f, -72f, 192f, -84.8f)
                curveToRelative(35.2f, -6.4f, 72f, -8.8f, 107.2f, -5.6f)
                curveToRelative(5.6f, 0.8f, 12f, 0.8f, 17.6f, 1.6f)
                curveToRelative(62.4f, 6.4f, 120.8f, 25.6f, 172.8f, 56.8f)
                curveToRelative(104.8f, 61.6f, 173.6f, 152.8f, 205.6f, 269.6f)
                curveToRelative(9.6f, 34.4f, 14.4f, 71.2f, 14.4f, 109.6f)
                lineTo(952.8f, 567.2f)
                curveToRelative(0f, 16.8f, -4f, 32.8f, -11.2f, 49.6f)
                curveToRelative(-2.4f, 4.8f, -4f, 10.4f, -4.8f, 16f)
                curveToRelative(-0.8f, 1.6f, -0.8f, 4f, -1.6f, 5.6f)
                curveToRelative(-46.4f, 156f, -174.4f, 273.6f, -333.6f, 306.4f)
                curveToRelative(-9.6f, 1.6f, -20f, 4f, -32.8f, 5.6f)
                curveToRelative(-6.4f, 0.8f, -8f, 4.8f, -9.6f, 8f)
                curveToRelative(-12.8f, 29.6f, -41.6f, 50.4f, -75.2f, 50.4f)
                close()
                moveTo(846.4f, 396.8f)
                horizontalLineToRelative(-6.4f)
                curveToRelative(-31.2f, 3.2f, -53.6f, 28.8f, -53.6f, 59.2f)
                lineTo(786.4f, 567.2f)
                curveToRelative(0f, 4.8f, 0.8f, 9.6f, 1.6f, 14.4f)
                curveToRelative(6.4f, 27.2f, 30.4f, 46.4f, 57.6f, 46.4f)
                curveToRelative(2.4f, 0f, 4.8f, 0f, 7.2f, -0.8f)
                curveToRelative(31.2f, -4f, 53.6f, -28.8f, 53.6f, -59.2f)
                lineTo(906.4f, 456.8f)
                curveToRelative(0f, -4.8f, -0.8f, -9.6f, -1.6f, -13.6f)
                curveToRelative(-7.2f, -27.2f, -31.2f, -46.4f, -58.4f, -46.4f)
                close()
                moveTo(178.4f, 396.8f)
                curveToRelative(-33.6f, 0f, -59.2f, 26.4f, -59.2f, 60f)
                verticalLineToRelative(109.6f)
                curveToRelative(0f, 4.8f, 0.8f, 9.6f, 1.6f, 13.6f)
                curveToRelative(6.4f, 27.2f, 30.4f, 46.4f, 57.6f, 46.4f)
                horizontalLineToRelative(6.4f)
                curveToRelative(31.2f, -3.2f, 53.6f, -28.8f, 53.6f, -59.2f)
                lineTo(238.4f, 456.8f)
                curveToRelative(-0.8f, -33.6f, -26.4f, -60f, -60f, -60f)
                close()
            }
        }.build()

        return _Service!!
    }

@Suppress("ObjectPropertyName")
private var _Service: ImageVector? = null
