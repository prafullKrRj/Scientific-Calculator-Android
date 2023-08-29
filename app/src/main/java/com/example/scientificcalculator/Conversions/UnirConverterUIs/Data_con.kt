package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import java.math.BigDecimal

@Composable
fun DataConverter(icon: Painter, title: String) {
    ConversionUI(getFactors(), title ,icon, null)
}
private fun getFactors(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Megabyte (MB)", BigDecimal("1.0")),
        ConversionFactorTypes("Gigabyte (GB)", BigDecimal("1024.0")),
        ConversionFactorTypes("Kilobyte (KB)", BigDecimal("0.000976563")),
        ConversionFactorTypes("Terabyte (TB)", BigDecimal("1048576.0")),
        ConversionFactorTypes("Petabyte (PB)", BigDecimal("1073741824.0")),
        ConversionFactorTypes("Exabyte (EB)", BigDecimal("1099511627776.0")),
        ConversionFactorTypes("Zettabyte (ZB)", BigDecimal("1125899906842624.0")),
        ConversionFactorTypes("Yottabyte (YB)", BigDecimal("1152921504606846976.0")),
        ConversionFactorTypes("Nibble", BigDecimal("0.00012207")),
        ConversionFactorTypes("Bit", BigDecimal("0.000000125")),
        ConversionFactorTypes("Kibibyte (KiB)", BigDecimal("0.000976563")),
        ConversionFactorTypes("Mebibyte (MiB)", BigDecimal("1.0")),
        ConversionFactorTypes("Gibibyte (GiB)", BigDecimal("1024.0"))
    )

}