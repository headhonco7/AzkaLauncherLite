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

val HotelProfile: ImageVector
    get() {
        if (_HotelProfile != null) {
            return _HotelProfile!!
        }
        _HotelProfile = ImageVector.Builder(
            name = "HotelProfile",
            defaultWidth = 132.dp,
            defaultHeight = 132.dp,
            viewportWidth = 132f,
            viewportHeight = 132f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(132f)
                    verticalLineToRelative(132f)
                    horizontalLineToRelative(-132f)
                    close()
                }
            ) {
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(129.8f, 127.6f)
                    horizontalLineTo(127.6f)
                    verticalLineTo(41.8f)
                    curveTo(127.6f, 40.48f, 126.72f, 39.6f, 125.4f, 39.6f)
                    horizontalLineTo(92.4f)
                    verticalLineTo(2.2f)
                    curveTo(92.4f, 0.88f, 91.52f, 0f, 90.2f, 0f)
                    horizontalLineTo(41.8f)
                    curveTo(40.48f, 0f, 39.6f, 0.88f, 39.6f, 2.2f)
                    verticalLineTo(39.6f)
                    horizontalLineTo(6.6f)
                    curveTo(5.28f, 39.6f, 4.4f, 40.48f, 4.4f, 41.8f)
                    verticalLineTo(127.6f)
                    horizontalLineTo(2.2f)
                    curveTo(0.88f, 127.6f, 0f, 128.48f, 0f, 129.8f)
                    curveTo(0f, 131.12f, 0.88f, 132f, 2.2f, 132f)
                    horizontalLineTo(6.6f)
                    horizontalLineTo(41.8f)
                    horizontalLineTo(52.8f)
                    horizontalLineTo(79.2f)
                    horizontalLineTo(90.2f)
                    horizontalLineTo(125.4f)
                    horizontalLineTo(129.8f)
                    curveTo(131.12f, 132f, 132f, 131.12f, 132f, 129.8f)
                    curveTo(132f, 128.48f, 131.12f, 127.6f, 129.8f, 127.6f)
                    close()
                    moveTo(8.8f, 44f)
                    horizontalLineTo(39.6f)
                    verticalLineTo(127.6f)
                    horizontalLineTo(8.8f)
                    verticalLineTo(44f)
                    close()
                    moveTo(44f, 41.8f)
                    verticalLineTo(4.4f)
                    horizontalLineTo(88f)
                    verticalLineTo(41.8f)
                    verticalLineTo(127.6f)
                    horizontalLineTo(81.4f)
                    verticalLineTo(107.8f)
                    curveTo(81.4f, 106.48f, 80.52f, 105.6f, 79.2f, 105.6f)
                    horizontalLineTo(52.8f)
                    curveTo(51.48f, 105.6f, 50.6f, 106.48f, 50.6f, 107.8f)
                    verticalLineTo(127.6f)
                    horizontalLineTo(44f)
                    verticalLineTo(41.8f)
                    close()
                    moveTo(55f, 110f)
                    horizontalLineTo(63.8f)
                    verticalLineTo(127.6f)
                    horizontalLineTo(55f)
                    verticalLineTo(110f)
                    close()
                    moveTo(68.2f, 127.6f)
                    verticalLineTo(110f)
                    horizontalLineTo(77f)
                    verticalLineTo(127.6f)
                    horizontalLineTo(68.2f)
                    close()
                    moveTo(92.4f, 127.6f)
                    verticalLineTo(44f)
                    horizontalLineTo(123.2f)
                    verticalLineTo(127.6f)
                    lineTo(92.4f, 127.6f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(50.6f, 48.4f)
                    horizontalLineTo(59.4f)
                    curveTo(60.72f, 48.4f, 61.6f, 47.52f, 61.6f, 46.2f)
                    verticalLineTo(35.2f)
                    horizontalLineTo(70.4f)
                    verticalLineTo(46.2f)
                    curveTo(70.4f, 47.52f, 71.28f, 48.4f, 72.6f, 48.4f)
                    horizontalLineTo(81.4f)
                    curveTo(82.72f, 48.4f, 83.6f, 47.52f, 83.6f, 46.2f)
                    verticalLineTo(11f)
                    curveTo(83.6f, 9.68f, 82.72f, 8.8f, 81.4f, 8.8f)
                    horizontalLineTo(72.6f)
                    curveTo(71.28f, 8.8f, 70.4f, 9.68f, 70.4f, 11f)
                    verticalLineTo(22f)
                    horizontalLineTo(61.6f)
                    verticalLineTo(11f)
                    curveTo(61.6f, 9.68f, 60.72f, 8.8f, 59.4f, 8.8f)
                    horizontalLineTo(50.6f)
                    curveTo(49.28f, 8.8f, 48.4f, 9.68f, 48.4f, 11f)
                    verticalLineTo(46.2f)
                    curveTo(48.4f, 47.52f, 49.28f, 48.4f, 50.6f, 48.4f)
                    close()
                    moveTo(52.8f, 13.2f)
                    horizontalLineTo(57.2f)
                    verticalLineTo(24.2f)
                    curveTo(57.2f, 25.52f, 58.08f, 26.4f, 59.4f, 26.4f)
                    horizontalLineTo(72.6f)
                    curveTo(73.92f, 26.4f, 74.8f, 25.52f, 74.8f, 24.2f)
                    verticalLineTo(13.2f)
                    horizontalLineTo(79.2f)
                    verticalLineTo(44f)
                    horizontalLineTo(74.8f)
                    verticalLineTo(33f)
                    curveTo(74.8f, 31.68f, 73.92f, 30.8f, 72.6f, 30.8f)
                    horizontalLineTo(59.4f)
                    curveTo(58.08f, 30.8f, 57.2f, 31.68f, 57.2f, 33f)
                    verticalLineTo(44f)
                    horizontalLineTo(52.8f)
                    verticalLineTo(13.2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(33f, 48.4f)
                    horizontalLineTo(15.4f)
                    curveTo(14.08f, 48.4f, 13.2f, 49.28f, 13.2f, 50.6f)
                    verticalLineTo(59.4f)
                    curveTo(13.2f, 60.72f, 14.08f, 61.6f, 15.4f, 61.6f)
                    horizontalLineTo(33f)
                    curveTo(34.32f, 61.6f, 35.2f, 60.72f, 35.2f, 59.4f)
                    verticalLineTo(50.6f)
                    curveTo(35.2f, 49.28f, 34.32f, 48.4f, 33f, 48.4f)
                    close()
                    moveTo(30.8f, 57.2f)
                    horizontalLineTo(17.6f)
                    verticalLineTo(52.8f)
                    horizontalLineTo(30.8f)
                    verticalLineTo(57.2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(77f, 52.8f)
                    horizontalLineTo(55f)
                    curveTo(53.68f, 52.8f, 52.8f, 53.68f, 52.8f, 55f)
                    verticalLineTo(63.8f)
                    curveTo(52.8f, 65.12f, 53.68f, 66f, 55f, 66f)
                    horizontalLineTo(77f)
                    curveTo(78.32f, 66f, 79.2f, 65.12f, 79.2f, 63.8f)
                    verticalLineTo(55f)
                    curveTo(79.2f, 53.68f, 78.32f, 52.8f, 77f, 52.8f)
                    close()
                    moveTo(74.8f, 61.6f)
                    horizontalLineTo(57.2f)
                    verticalLineTo(57.2f)
                    horizontalLineTo(74.8f)
                    verticalLineTo(61.6f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(77f, 70.4f)
                    horizontalLineTo(55f)
                    curveTo(53.68f, 70.4f, 52.8f, 71.28f, 52.8f, 72.6f)
                    verticalLineTo(81.4f)
                    curveTo(52.8f, 82.72f, 53.68f, 83.6f, 55f, 83.6f)
                    horizontalLineTo(77f)
                    curveTo(78.32f, 83.6f, 79.2f, 82.72f, 79.2f, 81.4f)
                    verticalLineTo(72.6f)
                    curveTo(79.2f, 71.28f, 78.32f, 70.4f, 77f, 70.4f)
                    close()
                    moveTo(74.8f, 79.2f)
                    horizontalLineTo(57.2f)
                    verticalLineTo(74.8f)
                    horizontalLineTo(74.8f)
                    verticalLineTo(79.2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(77f, 88f)
                    horizontalLineTo(55f)
                    curveTo(53.68f, 88f, 52.8f, 88.88f, 52.8f, 90.2f)
                    verticalLineTo(99f)
                    curveTo(52.8f, 100.32f, 53.68f, 101.2f, 55f, 101.2f)
                    horizontalLineTo(77f)
                    curveTo(78.32f, 101.2f, 79.2f, 100.32f, 79.2f, 99f)
                    verticalLineTo(90.2f)
                    curveTo(79.2f, 88.88f, 78.32f, 88f, 77f, 88f)
                    close()
                    moveTo(74.8f, 96.8f)
                    horizontalLineTo(57.2f)
                    verticalLineTo(92.4f)
                    horizontalLineTo(74.8f)
                    verticalLineTo(96.8f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(33f, 66f)
                    horizontalLineTo(15.4f)
                    curveTo(14.08f, 66f, 13.2f, 66.88f, 13.2f, 68.2f)
                    verticalLineTo(77f)
                    curveTo(13.2f, 78.32f, 14.08f, 79.2f, 15.4f, 79.2f)
                    horizontalLineTo(33f)
                    curveTo(34.32f, 79.2f, 35.2f, 78.32f, 35.2f, 77f)
                    verticalLineTo(68.2f)
                    curveTo(35.2f, 66.88f, 34.32f, 66f, 33f, 66f)
                    close()
                    moveTo(30.8f, 74.8f)
                    horizontalLineTo(17.6f)
                    verticalLineTo(70.4f)
                    horizontalLineTo(30.8f)
                    verticalLineTo(74.8f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(33f, 83.6f)
                    horizontalLineTo(15.4f)
                    curveTo(14.08f, 83.6f, 13.2f, 84.48f, 13.2f, 85.8f)
                    verticalLineTo(94.6f)
                    curveTo(13.2f, 95.92f, 14.08f, 96.8f, 15.4f, 96.8f)
                    horizontalLineTo(33f)
                    curveTo(34.32f, 96.8f, 35.2f, 95.92f, 35.2f, 94.6f)
                    verticalLineTo(85.8f)
                    curveTo(35.2f, 84.48f, 34.32f, 83.6f, 33f, 83.6f)
                    close()
                    moveTo(30.8f, 92.4f)
                    horizontalLineTo(17.6f)
                    verticalLineTo(88f)
                    horizontalLineTo(30.8f)
                    verticalLineTo(92.4f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(33f, 101.2f)
                    horizontalLineTo(15.4f)
                    curveTo(14.08f, 101.2f, 13.2f, 102.08f, 13.2f, 103.4f)
                    verticalLineTo(112.2f)
                    curveTo(13.2f, 113.52f, 14.08f, 114.4f, 15.4f, 114.4f)
                    horizontalLineTo(33f)
                    curveTo(34.32f, 114.4f, 35.2f, 113.52f, 35.2f, 112.2f)
                    verticalLineTo(103.4f)
                    curveTo(35.2f, 102.08f, 34.32f, 101.2f, 33f, 101.2f)
                    close()
                    moveTo(30.8f, 110f)
                    horizontalLineTo(17.6f)
                    verticalLineTo(105.6f)
                    horizontalLineTo(30.8f)
                    verticalLineTo(110f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(116.6f, 48.4f)
                    horizontalLineTo(99f)
                    curveTo(97.68f, 48.4f, 96.8f, 49.28f, 96.8f, 50.6f)
                    verticalLineTo(59.4f)
                    curveTo(96.8f, 60.72f, 97.68f, 61.6f, 99f, 61.6f)
                    horizontalLineTo(116.6f)
                    curveTo(117.92f, 61.6f, 118.8f, 60.72f, 118.8f, 59.4f)
                    verticalLineTo(50.6f)
                    curveTo(118.8f, 49.28f, 117.92f, 48.4f, 116.6f, 48.4f)
                    close()
                    moveTo(114.4f, 57.2f)
                    horizontalLineTo(101.2f)
                    verticalLineTo(52.8f)
                    horizontalLineTo(114.4f)
                    verticalLineTo(57.2f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(116.6f, 66f)
                    horizontalLineTo(99f)
                    curveTo(97.68f, 66f, 96.8f, 66.88f, 96.8f, 68.2f)
                    verticalLineTo(77f)
                    curveTo(96.8f, 78.32f, 97.68f, 79.2f, 99f, 79.2f)
                    horizontalLineTo(116.6f)
                    curveTo(117.92f, 79.2f, 118.8f, 78.32f, 118.8f, 77f)
                    verticalLineTo(68.2f)
                    curveTo(118.8f, 66.88f, 117.92f, 66f, 116.6f, 66f)
                    close()
                    moveTo(114.4f, 74.8f)
                    horizontalLineTo(101.2f)
                    verticalLineTo(70.4f)
                    horizontalLineTo(114.4f)
                    verticalLineTo(74.8f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(116.6f, 83.6f)
                    horizontalLineTo(99f)
                    curveTo(97.68f, 83.6f, 96.8f, 84.48f, 96.8f, 85.8f)
                    verticalLineTo(94.6f)
                    curveTo(96.8f, 95.92f, 97.68f, 96.8f, 99f, 96.8f)
                    horizontalLineTo(116.6f)
                    curveTo(117.92f, 96.8f, 118.8f, 95.92f, 118.8f, 94.6f)
                    verticalLineTo(85.8f)
                    curveTo(118.8f, 84.48f, 117.92f, 83.6f, 116.6f, 83.6f)
                    close()
                    moveTo(114.4f, 92.4f)
                    horizontalLineTo(101.2f)
                    verticalLineTo(88f)
                    horizontalLineTo(114.4f)
                    verticalLineTo(92.4f)
                    close()
                }
                path(fill = SolidColor(Color(0xFFD2D2D2))) {
                    moveTo(116.6f, 101.2f)
                    horizontalLineTo(99f)
                    curveTo(97.68f, 101.2f, 96.8f, 102.08f, 96.8f, 103.4f)
                    verticalLineTo(112.2f)
                    curveTo(96.8f, 113.52f, 97.68f, 114.4f, 99f, 114.4f)
                    horizontalLineTo(116.6f)
                    curveTo(117.92f, 114.4f, 118.8f, 113.52f, 118.8f, 112.2f)
                    verticalLineTo(103.4f)
                    curveTo(118.8f, 102.08f, 117.92f, 101.2f, 116.6f, 101.2f)
                    close()
                    moveTo(114.4f, 110f)
                    horizontalLineTo(101.2f)
                    verticalLineTo(105.6f)
                    horizontalLineTo(114.4f)
                    verticalLineTo(110f)
                    close()
                }
            }
        }.build()

        return _HotelProfile!!
    }

@Suppress("ObjectPropertyName")
private var _HotelProfile: ImageVector? = null
