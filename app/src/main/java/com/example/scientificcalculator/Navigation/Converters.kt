package com.example.scientificcalculator.Navigation

sealed class Converters(val route: String){

    object UnitConverterScreen: Converters("unit_converter_main_screen")
    object Age: Converters("Age")
    object Area: Converters("Area")
    object BMI: Converters("BMI")
    object Data: Converters("Data")
    object Length: Converters("Length")
    object NumeralSystem: Converters("Numeral System")
    object Speed: Converters("Speed")
    object Temperature: Converters("Temperature")
    object Volume: Converters("Volume")
    object Time: Converters("Time")
    object Mass: Converters("Mass")
}