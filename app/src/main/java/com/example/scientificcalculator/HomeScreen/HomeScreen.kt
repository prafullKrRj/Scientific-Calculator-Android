package com.example.scientificcalculator.HomeScreen

import androidx.compose.runtime.Composable
import com.example.scientificcalculator.Data.ScreenCompatibility.WindowInfo
import com.example.scientificcalculator.Data.ScreenCompatibility.rememberWindowInfo


@Composable
fun HomeScreen() {
    val windowInfo = rememberWindowInfo()

    if (windowInfo.screenWidthInfo == WindowInfo.WindowType.Compact){
        ForCompact()
    }
    else{
        ForLarge()
    }
}
