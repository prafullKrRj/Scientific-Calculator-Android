package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import java.math.BigDecimal

@Composable
fun MassConverter(icon: Painter, title: String) {
    ConversionUI(getFactors(), title ,icon, null)
}

private fun getFactors(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Gram (g)", BigDecimal("1.0")),
        ConversionFactorTypes("Kilogram (kg)", BigDecimal("1000.0")),
        ConversionFactorTypes("Milligram (mg)", BigDecimal("0.001")),
        ConversionFactorTypes("Microgram (μg)", BigDecimal("0.000001")),
        ConversionFactorTypes("Nanogram (ng)", BigDecimal("0.000000001")),
        ConversionFactorTypes("Metric Ton (t)", BigDecimal("1000000.0")),
        ConversionFactorTypes("Ounce (oz)", BigDecimal("28.3495")),
        ConversionFactorTypes("Pound (lb)", BigDecimal("453.592")),
        ConversionFactorTypes("Stone (st)", BigDecimal("6350.29")),
        ConversionFactorTypes("Long Ton (ton)", BigDecimal("1016046.91")),
        ConversionFactorTypes("Short Ton", BigDecimal("907184.74")),
        ConversionFactorTypes("Carat (ct)", BigDecimal("0.2")),
        ConversionFactorTypes("Atomic Mass Unit (u)", BigDecimal("0.00000000000000000000000166054")),
        ConversionFactorTypes("Grain (gr)", BigDecimal("0.0647989")),
        ConversionFactorTypes("Pennyweight (dwt)", BigDecimal("1.55517")),
        ConversionFactorTypes("Troy Ounce (ozt)", BigDecimal("31.1035")),
        ConversionFactorTypes("Troy Pound (lbt)", BigDecimal("373.242")),
        ConversionFactorTypes("Hundredweight (cwt)", BigDecimal("45359.2")),
        ConversionFactorTypes("Quarter (qtr)", BigDecimal("12700.6")),
        ConversionFactorTypes("Scruple", BigDecimal("1.296"))
    )

}