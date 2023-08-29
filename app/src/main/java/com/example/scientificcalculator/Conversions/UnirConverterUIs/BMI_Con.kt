package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes

@Composable
fun BMI(icon: Painter, title: String) {
    ConversionUI(getFactorOne(), title ,icon, getFactorTwo())
}
private fun getFactorOne(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Kilograms", 1000.toBigDecimal()),
        ConversionFactorTypes("Pounds", 453.59237.toBigDecimal()))
}
private fun getFactorTwo(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Centimeters", 0.01.toBigDecimal()),
        ConversionFactorTypes("Meters", 1.0.toBigDecimal()),
        ConversionFactorTypes("Feet", 0.3048.toBigDecimal()),
        ConversionFactorTypes("inches", 0.0254.toBigDecimal()))
}
