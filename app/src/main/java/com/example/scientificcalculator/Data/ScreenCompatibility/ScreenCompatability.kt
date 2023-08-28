package com.example.scientificcalculator.Data.ScreenCompatibility

import androidx.compose.ui.unit.Dp

data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screenHeightInfo: WindowType,
    val screenWidth: Dp,
    val screenHeight: Dp
){
    sealed class WindowType {
        object Compact: WindowType()
        object Medium: WindowType()
        object Expanded: WindowType()
    }
}