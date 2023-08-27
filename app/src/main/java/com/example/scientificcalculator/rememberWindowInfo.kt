package com.example.scientificcalculator

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp


@Composable
fun rememberWindowInfo() : WindowInfo{
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenHeightInfo =
        when{
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> {
                WindowInfo.WindowType.Expanded
            }
        },
        screenWidthInfo =
        when{
            configuration.screenWidthDp < 480 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 900 -> WindowInfo.WindowType.Medium
            else -> {
                WindowInfo.WindowType.Expanded
            }
        },
        screenHeight = configuration.screenHeightDp.dp,
        screenWidth = configuration.screenWidthDp.dp
    )
}