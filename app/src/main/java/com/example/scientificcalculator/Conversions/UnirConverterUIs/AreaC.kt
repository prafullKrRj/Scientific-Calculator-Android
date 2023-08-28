package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.scientificcalculator.Conversions.ConversionUI
import com.example.scientificcalculator.Data.ConversionDataIterms.ConversionFactorTypes

@Composable
fun AreaC(title: String, navController: NavController) {
    ConversionUI(conversionFactorTypes = getList(), title = title, navController = navController)
}
private fun getList(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Square Meter (m^2)", 1.0),
        ConversionFactorTypes("Square Kilometer (km^2)", 1e6),
        ConversionFactorTypes("Square Mile (mi^2)", 2.58999e6),
        ConversionFactorTypes("Hectare (ha)", 10000.0),
        ConversionFactorTypes("Acre (ac)", 4046.86),
        ConversionFactorTypes("Square Yard (yd^2)", 0.836127),
        ConversionFactorTypes("Square Foot (ft^2)", 0.092903),
        ConversionFactorTypes("Square Inch (in^2)", 0.00064516),
        ConversionFactorTypes("Square Centimeter (cm^2)", 0.0001),
        ConversionFactorTypes("Square Millimeter (mm^2)", 1e-6),
        ConversionFactorTypes("Square Decimeter (dm^2)", 0.01),
        ConversionFactorTypes("Are (a)", 100.0),
        ConversionFactorTypes("Square Rod (rd^2)", 25.2929),
        ConversionFactorTypes("Barn (b)", 1e-28),
        ConversionFactorTypes("Rood", 1011.71),
        ConversionFactorTypes("Sabin", 0.092903),
        ConversionFactorTypes("Square Furlong", 40468.6),
        ConversionFactorTypes("Square Chain", 404.686),
        ConversionFactorTypes("Perch", 25.2929),
        ConversionFactorTypes("Square Mil", 6.4516e-10)
    )
}