package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes

@Composable
fun TemperatureConverter(icon: Painter, title: String) {
    ConversionUI(getFactors(), title ,icon, null)
}
private fun getFactors(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Celsius (°C)", 1.0.toBigDecimal()),
        ConversionFactorTypes("Kelvin (K)", (-272.15).toBigDecimal()),
        ConversionFactorTypes("Fahrenheit (°F)", (-17.2222).toBigDecimal()),
        ConversionFactorTypes("Rankine (°R)", (-273.15).toBigDecimal()),
        ConversionFactorTypes("Delisle (°De)", 33.75.toBigDecimal()),
        ConversionFactorTypes("Newton (°N)", (-89.8087).toBigDecimal()),
        ConversionFactorTypes("Réaumur (°Ré)", 0.8.toBigDecimal()),
        ConversionFactorTypes("Rømer (°Rø)", (-135.90375).toBigDecimal())
    )
    
}