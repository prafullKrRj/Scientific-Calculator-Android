package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import java.math.BigDecimal

@Composable
fun AreaC(icon: Painter, title: String) {
    ConversionUI(getFactors(), title ,icon, null)
}
private fun getFactors(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Square Meter (m^2)", BigDecimal("1.0")),
        ConversionFactorTypes("Square Kilometer (km^2)", BigDecimal("1000000.0")),
        ConversionFactorTypes("Square Mile (mi^2)", BigDecimal("2589990.0")),
        ConversionFactorTypes("Hectare (ha)", BigDecimal("10000.0")),
        ConversionFactorTypes("Acre (ac)", BigDecimal("4046.86")),
        ConversionFactorTypes("Square Yard (yd^2)", BigDecimal("0.836127")),
        ConversionFactorTypes("Square Foot (ft^2)", BigDecimal("0.092903")),
        ConversionFactorTypes("Square Inch (in^2)", BigDecimal("0.00064516")),
        ConversionFactorTypes("Square Centimeter (cm^2)", BigDecimal("0.0001")),
        ConversionFactorTypes("Square Millimeter (mm^2)", BigDecimal("0.000001")),
        ConversionFactorTypes("Square Decimeter (dm^2)", BigDecimal("0.01")),
        ConversionFactorTypes("Are (a)", BigDecimal("100.0")),
        ConversionFactorTypes("Square Rod (rd^2)", BigDecimal("25.2929")),
        ConversionFactorTypes("Barn (b)", BigDecimal("0.000000000000000000000000001")),
        ConversionFactorTypes("Rood", BigDecimal("1011.71")),
        ConversionFactorTypes("Sabin", BigDecimal("0.092903")),
        ConversionFactorTypes("Square Furlong", BigDecimal("40468.6")),
        ConversionFactorTypes("Square Chain", BigDecimal("404.686")),
        ConversionFactorTypes("Perch", BigDecimal("25.2929")),
        ConversionFactorTypes("Square Mil", BigDecimal("0.00000000064516"))
    )

}
fun areaCon(){

}