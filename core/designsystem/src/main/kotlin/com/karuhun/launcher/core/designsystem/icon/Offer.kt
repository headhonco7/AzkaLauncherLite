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
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Offer: ImageVector
    get() {
        if (_Offer != null) {
            return _Offer!!
        }
        _Offer = ImageVector.Builder(
            name = "Offer",
            defaultWidth = 77.dp,
            defaultHeight = 77.dp,
            viewportWidth = 77f,
            viewportHeight = 77f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(77f)
                    verticalLineToRelative(77f)
                    horizontalLineToRelative(-77f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(77f, 40.967f)
                    lineTo(70.725f, 33.833f)
                    lineTo(74.534f, 26.121f)
                    lineTo(66.868f, 22.339f)
                    lineTo(67.468f, 13.025f)
                    lineTo(57.958f, 12.413f)
                    lineTo(55.082f, 3.912f)
                    lineTo(46.857f, 6.699f)
                    lineTo(40.966f, 0.001f)
                    lineTo(34.018f, 6.112f)
                    lineTo(25.619f, 1.963f)
                    lineTo(21.605f, 10.086f)
                    lineTo(13.024f, 9.537f)
                    lineTo(12.458f, 18.353f)
                    lineTo(3.409f, 21.417f)
                    lineTo(6.443f, 30.371f)
                    lineTo(0f, 36.033f)
                    lineTo(5.629f, 42.434f)
                    lineTo(1.459f, 50.881f)
                    lineTo(10.102f, 55.148f)
                    lineTo(9.535f, 63.98f)
                    lineTo(18.011f, 64.524f)
                    lineTo(20.914f, 73.088f)
                    lineTo(29.914f, 70.041f)
                    lineTo(36.034f, 76.999f)
                    lineTo(42.619f, 71.206f)
                    lineTo(50.376f, 75.037f)
                    lineTo(54.417f, 66.852f)
                    lineTo(63.982f, 67.469f)
                    lineTo(64.568f, 58.301f)
                    lineTo(72.587f, 55.584f)
                    lineTo(69.785f, 47.313f)
                    lineTo(77f, 40.967f)
                    close()
                    moveTo(62.253f, 56.528f)
                    lineTo(61.717f, 64.893f)
                    lineTo(52.96f, 64.333f)
                    lineTo(49.275f, 71.795f)
                    lineTo(42.237f, 68.319f)
                    lineTo(36.256f, 73.58f)
                    lineTo(30.668f, 67.224f)
                    lineTo(22.431f, 70.015f)
                    lineTo(19.782f, 62.208f)
                    lineTo(12.109f, 61.717f)
                    lineTo(12.623f, 53.689f)
                    lineTo(4.704f, 49.779f)
                    lineTo(8.521f, 42.054f)
                    lineTo(3.421f, 36.257f)
                    lineTo(9.256f, 31.126f)
                    lineTo(6.482f, 22.935f)
                    lineTo(14.773f, 20.126f)
                    lineTo(15.286f, 12.106f)
                    lineTo(23.066f, 12.605f)
                    lineTo(26.717f, 5.206f)
                    lineTo(34.401f, 9.003f)
                    lineTo(40.749f, 3.42f)
                    lineTo(46.104f, 9.511f)
                    lineTo(53.566f, 6.984f)
                    lineTo(56.189f, 14.726f)
                    lineTo(64.896f, 15.283f)
                    lineTo(64.351f, 23.792f)
                    lineTo(71.294f, 27.222f)
                    lineTo(67.838f, 34.213f)
                    lineTo(73.583f, 40.748f)
                    lineTo(66.971f, 46.562f)
                    lineTo(69.516f, 54.066f)
                    lineTo(62.253f, 56.528f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(47.469f, 35.706f)
                    curveTo(43.859f, 35.706f, 40.876f, 38.77f, 40.876f, 44.273f)
                    curveTo(40.916f, 49.731f, 43.857f, 52.459f, 47.259f, 52.459f)
                    curveTo(50.746f, 52.459f, 53.768f, 49.605f, 53.768f, 43.849f)
                    curveTo(53.77f, 38.645f, 51.292f, 35.706f, 47.469f, 35.706f)
                    close()
                    moveTo(47.343f, 50.235f)
                    curveTo(45.076f, 50.235f, 43.732f, 47.59f, 43.774f, 44.107f)
                    curveTo(43.774f, 40.662f, 45.034f, 37.933f, 47.343f, 37.933f)
                    curveTo(49.904f, 37.933f, 50.869f, 40.704f, 50.869f, 44.024f)
                    curveTo(50.869f, 47.631f, 49.78f, 50.235f, 47.343f, 50.235f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(36.005f, 32.558f)
                    curveTo(36.005f, 27.352f, 33.486f, 24.409f, 29.665f, 24.409f)
                    curveTo(26.054f, 24.409f, 23.073f, 27.477f, 23.073f, 32.935f)
                    curveTo(23.115f, 38.434f, 26.054f, 41.162f, 29.455f, 41.162f)
                    curveTo(32.982f, 41.164f, 36.005f, 38.309f, 36.005f, 32.558f)
                    close()
                    moveTo(26.011f, 32.81f)
                    curveTo(26.011f, 29.365f, 27.231f, 26.636f, 29.538f, 26.636f)
                    curveTo(32.1f, 26.636f, 33.065f, 29.407f, 33.065f, 32.727f)
                    curveTo(33.065f, 36.335f, 31.973f, 38.939f, 29.538f, 38.939f)
                    curveTo(27.231f, 38.938f, 25.927f, 36.293f, 26.011f, 32.81f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(45.243f, 24.409f)
                    lineTo(29.202f, 52.629f)
                    horizontalLineTo(31.552f)
                    lineTo(47.595f, 24.409f)
                    horizontalLineTo(45.243f)
                    close()
                }
            }
        }.build()

        return _Offer!!
    }

@Suppress("ObjectPropertyName")
private var _Offer: ImageVector? = null
