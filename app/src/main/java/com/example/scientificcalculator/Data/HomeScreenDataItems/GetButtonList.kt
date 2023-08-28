package com.example.scientificcalculator.Data.HomeScreenDataItems

import androidx.compose.ui.graphics.Color
import com.example.scientificcalculator.ui.theme.grey300
import com.example.scientificcalculator.ui.theme.grey500
import com.example.scientificcalculator.ui.theme.grey700
import com.example.scientificcalculator.ui.theme.indigo400

class GetButtonList {

    private val color1: Color = grey700
    private val color2: Color = grey300
    private val color3: Color = grey500
    private val color4: Color = indigo400
    fun compactButtonList() : List<ButtonFeature>{
        return listOf(
            ButtonFeature(color1, "AC"),
            ButtonFeature(color1, "X"),
            ButtonFeature(color1, "%"),
            ButtonFeature(color1, "/"),
            ButtonFeature(color2, "7"),
            ButtonFeature(color2, "8"),
            ButtonFeature(color2, "9"),
            ButtonFeature(color1, "x"),
            ButtonFeature(color2, "4"),
            ButtonFeature(color2, "5"),
            ButtonFeature(color2, "6"),
            ButtonFeature(color1, "-"),
            ButtonFeature(color2, "1"),
            ButtonFeature(color2, "2"),
            ButtonFeature(color2, "3"),
            ButtonFeature(color1, "+"),
            ButtonFeature(color1, ""),
            ButtonFeature(color2, "0"),
            ButtonFeature(color2, "."),
            ButtonFeature(color1, "="),
        )
    }

    fun nonCompactButtonList() : List<ButtonFeature>{
        val base = "x"
        val powerString = "$base\u207B"

        val underRootString = "\u221A$base"


        return listOf(
            ButtonFeature(color3, powerString),
            ButtonFeature(color1, "AC"),
            ButtonFeature(color1, "X"),
            ButtonFeature(color1, "%"),
            ButtonFeature(color1, "/"),
            ButtonFeature(color3, underRootString),
            ButtonFeature(color2, "7"),
            ButtonFeature(color2, "8"),
            ButtonFeature(color2, "9"),
            ButtonFeature(color1, "x"),
            ButtonFeature(color3, "x!"),
            ButtonFeature(color2, "4"),
            ButtonFeature(color2, "5"),
            ButtonFeature(color2, "6"),
            ButtonFeature(color1, "-"),
            ButtonFeature(color3, "1/x"),
            ButtonFeature(color2, "1"),
            ButtonFeature(color2, "2"),
            ButtonFeature(color2, "3"),
            ButtonFeature(color1, "+"),
            ButtonFeature(color1, ""),
            ButtonFeature(color2, "π"),
            ButtonFeature(color2, "0"),
            ButtonFeature(color2, "."),
            ButtonFeature(color1, "=")
        )
    }

    fun getExtraButton(): List<ButtonFeature>{
        return listOf(
            ButtonFeature(color4, "e"),
            ButtonFeature(color4, "sin x"),
            ButtonFeature(color4, "log"),
            ButtonFeature(color4, "cos x"),
            ButtonFeature(color4, "ln"),
            ButtonFeature(color4, "tan"),
            ButtonFeature(color4, "sin-1"),
            ButtonFeature(color4, "( )"),
            ButtonFeature(color4, "tan-1"),
            ButtonFeature(color4, "cos-1"),

        )
    }
}