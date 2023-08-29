package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes

@Composable
fun NumeralSystem(icon: Painter, title: String) {
    ConversionUI(getFactorOne(), title ,icon, null)
}
private fun getFactorOne(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Binary", 0.0.toBigDecimal()),
        ConversionFactorTypes("HexaDecimal", 453.59237.toBigDecimal()),
        ConversionFactorTypes("Decimal", 453.59237.toBigDecimal()),
        ConversionFactorTypes("Octal", 453.59237.toBigDecimal())
    )
}
