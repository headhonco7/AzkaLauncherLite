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

package com.karuhun.core.model

data class Hotel(
    val id: Int? = 1,
    val name: String?,
    val phone: String?,
    val email: String?,
    val website: String?,
    val defaultGreeting: String?,
    val passwordSetting: String?,
    val logoWhite: String?,
    val logoBlack: String?,
    val primaryColor: String?,
    val mainPhoto: String?,
    val backgroundPhoto: String?,
    val introVideo: String?,
    val welcomeText: String?,
    val runningText: String?,
) {
    companion object {
        val Empty = Hotel(
            id = null,
            name = null,
            phone = null,
            email = null,
            website = null,
            defaultGreeting = null,
            passwordSetting = null,
            logoWhite = null,
            logoBlack = null,
            primaryColor = null,
            mainPhoto = null,
            backgroundPhoto = null,
            introVideo = null,
            welcomeText = null,
            runningText = null
        )
    }
}