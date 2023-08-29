package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import java.math.BigDecimal

@Composable
fun VolumeConverter(icon: Painter, title: String) {
    ConversionUI(getFactors(), title ,icon, null)
}
private fun getFactors(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Cubic Meter (m³)", BigDecimal("1.0")),
        ConversionFactorTypes("Cubic Kilometer (km³)", BigDecimal("1000000000.0")),
        ConversionFactorTypes("Cubic Centimeter (cm³)", BigDecimal("0.000001")),
        ConversionFactorTypes("Cubic Millimeter (mm³)", BigDecimal("0.000000001")),
        ConversionFactorTypes("Liter (L)", BigDecimal("0.001")),
        ConversionFactorTypes("Milliliter (mL)", BigDecimal("0.000001")),
        ConversionFactorTypes("Gallon (gal)", BigDecimal("0.00378541")),
        ConversionFactorTypes("Quart (qt)", BigDecimal("0.000946353")),
        ConversionFactorTypes("Pint (pt)", BigDecimal("0.000473176")),
        ConversionFactorTypes("Fluid Ounce (fl oz)", BigDecimal("0.0000295735")),
        ConversionFactorTypes("Cubic Yard (yd³)", BigDecimal("0.764554858")),
        ConversionFactorTypes("Cubic Foot (ft³)", BigDecimal("0.0283168")),
        ConversionFactorTypes("Cubic Inch (in³)", BigDecimal("0.0000163871")),
        ConversionFactorTypes("Acre-Foot", BigDecimal("1233.48")),
        ConversionFactorTypes("Teaspoon (tsp)", BigDecimal("0.00000492892")),
        ConversionFactorTypes("Tablespoon (tbsp)", BigDecimal("0.0000147868")),
        ConversionFactorTypes("Cup", BigDecimal("0.000236588")),
        ConversionFactorTypes("Fluid Dram (fl dr)", BigDecimal("0.00000369669"))
    )

}