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

package com.karuhun.core.ui.navigation.extension

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow


val <T> Flow<T>.collectWithLifecycle: @Composable (result: (T) -> Unit) -> Unit
    @Composable get() = { function ->
        CollectWithLaunchedEffect {
            function(it)
        }
    }

@Composable
fun <T> Flow<T>.CollectWithLaunchedEffect(
    result: (T) -> Unit,
) {
    LaunchedEffect(Unit) {
        collect { effect ->
            result(effect)
        }
    }
}

inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit
): Modifier = composed {
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}

inline fun Modifier.conditional(
    condition: Boolean,
    modifier: Modifier.() -> Modifier,
): Modifier {
    return if (condition) {
        this then modifier(Modifier)
    } else {
        this
    }
}


@Composable
fun Modifier.boldBorder(
    radius: Int = 16,
    color: Color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.8f),
    width: Dp = 2.dp
): Modifier {
    return this.border(
        width = width,
        color = color,
        shape = RoundedCornerShape(radius.dp)
    )
}