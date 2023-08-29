package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import java.math.BigDecimal

@Composable
fun LengthConverter(icon: Painter, title: String) {
    ConversionUI(getFactors(), title ,icon, null)
}
private fun getFactors(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Meter (m)", BigDecimal("1.0")),
        ConversionFactorTypes("Kilometer (km)", BigDecimal("1000.0")),
        ConversionFactorTypes("Centimeter (cm)", BigDecimal("0.01")),
        ConversionFactorTypes("Millimeter (mm)", BigDecimal("0.001")),
        ConversionFactorTypes("Micrometer (μm)", BigDecimal("0.000001")),
        ConversionFactorTypes("Nanometer (nm)", BigDecimal("0.000000001")),
        ConversionFactorTypes("Mile (mi)", BigDecimal("1609.34")),
        ConversionFactorTypes("Yard (yd)", BigDecimal("0.9144")),
        ConversionFactorTypes("Foot (ft)", BigDecimal("0.3048")),
        ConversionFactorTypes("Inch (in)", BigDecimal("0.0254")),
        ConversionFactorTypes("Nautical Mile", BigDecimal("1852.0")),
        ConversionFactorTypes("League", BigDecimal("4828.0")),
        ConversionFactorTypes("Furlong", BigDecimal("201.168")),
        ConversionFactorTypes("Rod", BigDecimal("5.0292")),
        ConversionFactorTypes("Chain", BigDecimal("20.1168"))
    )

}