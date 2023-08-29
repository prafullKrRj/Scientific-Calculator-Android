package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import java.math.BigDecimal

@Composable
fun SpeedConverter(icon: Painter, title: String) {
    ConversionUI(getFactors(), title ,icon, null)
}
private fun getFactors(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Meters per Second (m/s)", BigDecimal("1.0")),
        ConversionFactorTypes("Kilometers per Hour (km/h)", BigDecimal("0.277778")),
        ConversionFactorTypes("Miles per Hour (mph)", BigDecimal("0.44704")),
        ConversionFactorTypes("Knot (kn)", BigDecimal("0.514444")),
        ConversionFactorTypes("Feet per Second (ft/s)", BigDecimal("0.3048")),
        ConversionFactorTypes("Mach (speed of sound)", BigDecimal("343.0")),
        ConversionFactorTypes("Speed of Light", BigDecimal("299792458.0")),
        ConversionFactorTypes("Mach (SI standard)", BigDecimal("340.3")),
        ConversionFactorTypes("Speed of Sound in Air", BigDecimal("343.0")),
        ConversionFactorTypes("Speed of Sound in Water", BigDecimal("1482.0")),
        ConversionFactorTypes("Speed of Sound in Steel", BigDecimal("5130.0")),
        ConversionFactorTypes("Speed of Sound in Aluminum", BigDecimal("6320.0")),
        ConversionFactorTypes("Speed of Sound in Glass", BigDecimal("4540.0")),
        ConversionFactorTypes("Escape Velocity from Earth", BigDecimal("11186.0")),
        ConversionFactorTypes("Escape Velocity from Moon", BigDecimal("2380.0"))
    )

}