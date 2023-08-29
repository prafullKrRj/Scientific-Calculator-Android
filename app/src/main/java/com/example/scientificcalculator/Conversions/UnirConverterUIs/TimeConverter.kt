package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import java.math.BigDecimal

@Composable
fun TimeConverter(icon: Painter, title: String) {
    ConversionUI(getFactors(), title ,icon, null)
}
private fun getFactors(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Minute (min)", BigDecimal("1.0")),
        ConversionFactorTypes("Hour (hr)", BigDecimal("60.0")),
        ConversionFactorTypes("Day (d)", BigDecimal("1440.0")),
        ConversionFactorTypes("Second (s)", BigDecimal("0.0166667")),
        ConversionFactorTypes("Millisecond (ms)", BigDecimal("0.0000166667")),
        ConversionFactorTypes("Microsecond (μs)", BigDecimal("0.0000000166667")),
        ConversionFactorTypes("Nanosecond (ns)", BigDecimal("0.0000000000166667")),
        ConversionFactorTypes("Week", BigDecimal("10080.0")),
        ConversionFactorTypes("Fortnight", BigDecimal("20160.0")),
        ConversionFactorTypes("Month (average)", BigDecimal("43800.0")),
        ConversionFactorTypes("Year (average)", BigDecimal("525600.0")),
        ConversionFactorTypes("Decade", BigDecimal("5256000.0")),
        ConversionFactorTypes("Century", BigDecimal("52560000.0"))
    )

}