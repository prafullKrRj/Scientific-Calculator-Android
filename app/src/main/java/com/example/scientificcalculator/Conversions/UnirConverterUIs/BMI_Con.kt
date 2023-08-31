package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scientificcalculator.Conversions.SelectionBox
import com.example.scientificcalculator.Conversions.numbers
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import com.example.scientificcalculator.R
import com.example.scientificcalculator.ui.theme.grey200
import com.example.scientificcalculator.ui.theme.grey300
import com.example.scientificcalculator.ui.theme.grey50
import com.example.scientificcalculator.ui.theme.grey700
import com.example.scientificcalculator.ui.theme.grey800
import com.example.scientificcalculator.ui.theme.grey900

private fun getFactorOne(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Kilograms", 1.toBigDecimal()),
        ConversionFactorTypes("Pounds", 0.45359.toBigDecimal()))
}
private fun getFactorTwo(): List<ConversionFactorTypes>{
    return listOf(
        ConversionFactorTypes("Centimeters", 0.01.toBigDecimal()),
        ConversionFactorTypes("Meters", 1.0.toBigDecimal()),
        ConversionFactorTypes("Feet", 0.3048.toBigDecimal()),
        ConversionFactorTypes("Inches", 0.0254.toBigDecimal()))
}

@Composable
fun BMI(icon: Painter, title: String) {
    var textOne by rememberSaveable {
        mutableStateOf("0")
    }
    var textTwo by rememberSaveable {
        mutableStateOf("0")
    }

    var text1 by remember {
        mutableStateOf("Kilograms")
    }
    var text2 by remember {
        mutableStateOf("Meters")
    }
    var selected by remember {
        mutableStateOf(1)
    }
    var showWeightDilog by remember {
        mutableStateOf(false)
    }
    var showHeightDialog by remember {
        mutableStateOf(false)
    }
    var isClicked1 by remember {
        mutableStateOf(true)
    }
    var isClicked2 by remember {
        mutableStateOf(true)
    }
    var showNumPad by remember {
        mutableStateOf(true)
    }
    var showDetails by remember {
        mutableStateOf(false)
    }
    var selectedH by remember {
        mutableStateOf(2)
    }
    var selectedW by remember {
        mutableStateOf(1)
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
    ){
        Row (
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(painter = icon, contentDescription = title, tint = Color.White, modifier = Modifier.size(22.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                color = Color.White,
                fontSize = 22.sp
            )
        }
        Column (
            modifier = Modifier
                .background(grey700)
                .padding(vertical = 15.dp)
                .weight(.5f),
            verticalArrangement = Arrangement.SpaceAround
        ){
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 13.dp)
                    .padding(horizontal = 16.dp)
                ,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(
                    onClick = {
                        showWeightDilog = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                ) {
                    Text(text = text1)
                    Spacer(modifier = Modifier.width(2.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = textOne,
                    color = if (selected == 1) Color.Yellow else Color.White,
                    fontSize = 22.sp,
                    modifier = Modifier.clickable {
                        selected = 1
                        showDetails = false
                        showNumPad = true
                    }
                )
            }

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 13.dp)
                    .padding(horizontal = 16.dp)
                ,
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(
                    onClick = {
                        showHeightDialog = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                ) {
                    Text(text = text2, color = grey50)
                    Spacer(modifier = Modifier.width(2.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = textTwo,
                    color = if (selected == 2) Color.Yellow else Color.White,
                    fontSize = 22.sp,
                    modifier = Modifier.clickable {
                        selected = 2
                        showDetails = false
                        showNumPad = true
                    }
                )
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = {
                    textOne = "0"
                    textTwo = "0"
                },
                modifier = Modifier
                    .weight(.5f)
                    .padding(12.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = grey700)
            ) {
                Text(text = "AC", color = grey50)
            }
            Button(
                onClick =
                {
                    if (textOne.length == 1){
                        textOne = "0"
                        textTwo = "0"
                    }else{
                        textOne = textOne.substring(0, textOne.length-1)
                    }
                },
                modifier = Modifier
                    .weight(.5f)
                    .padding(12.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = grey700)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = "delete",
                    tint = grey50
                )
            }
            Button(
                onClick = {
                    showNumPad = false
                    showDetails = true

                },
                modifier = Modifier
                    .weight(.5f)
                    .padding(12.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = grey700)
            ) {
                Text(text = "GO", color = grey50)
            }
        }

        if (showNumPad){
            LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier
                .wrapContentHeight()
                .padding(start = 16.dp, end = 8.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutLinearInEasing
                    )
                )){
                items(numbers.size){
                    Box(
                        modifier =
                        if (numbers[it] == "" ) {
                            Modifier
                                .size(100.dp)
                                .padding(6.dp)
                                .background(
                                    if (numbers[it] != "") grey800 else grey900,
                                    CircleShape
                                )
                        }else{
                            Modifier
                                .size(100.dp)
                                .padding(6.dp)
                                .background(
                                    if (numbers[it] != "") grey800 else grey900,
                                    CircleShape
                                )
                                .clip(CircleShape)
                                .clickable {
                                    if (selected == 1) {
                                        isClicked2 = true
                                        if (textOne == "0") {
                                            textOne = ""
                                            isClicked1 = false
                                            textOne += numbers[it]
                                        } else {
                                            if (isClicked1) {
                                                textOne = ""
                                                isClicked1 = false
                                            }
                                            textOne += numbers[it]
                                        }
                                    } else {
                                        isClicked1 = true
                                        if (textTwo == "0") {
                                            textTwo = ""
                                            isClicked2 = false
                                            textTwo += numbers[it]
                                        } else {
                                            if (isClicked2) {
                                                textTwo = ""
                                                isClicked2 = false
                                            }
                                            textTwo += numbers[it]
                                        }
                                    }
                                }
                        },
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = numbers[it], color = grey50, fontSize = 20.sp)
                    }
                }
            }
        }
        if (showDetails){
            val wgt = textOne.toDouble()
            val weight = if (selectedW == 1) wgt else wgt * 0.45359237
            val db = textTwo.toDouble()
            val height =
                when (selectedH){
                    1 -> 0.01 * db
                    2 -> db
                    3 -> 0.3048 * db
                    else -> 0.0254 * db
            }
            if (height <= .40 || weight < 1){
                ShowDetails(bmi = "0.0", cat = "Enter correct details")
            }else{
                val bmi = calculate(weight, height)
                ShowDetails(bmi[0], bmi[1])
            }

        }
    }

    if (showWeightDilog){
        SelectionBox(list = getFactorOne()){list ->
            if (list.isNotEmpty()){
                text1 = list[0]
                selectedW = when(list[0]){
                    "Kilograms" -> 1
                    else -> 2
                }
            }
            showWeightDilog = false
        }
    }

    if (showHeightDialog){
        SelectionBox(list = getFactorTwo()){ list ->
            if (list.isNotEmpty()){
                text2 = list[0]
                selectedH = when(list[0]){
                    "Centimeters" -> 1
                    "Meters" -> 2
                    "Feet" -> 3
                    else -> 4
                }
            }
            showHeightDialog = false
        }
    }
}

@Composable
fun ShowDetails(bmi: String, cat: String) {
    Column(modifier = Modifier
        .padding(16.dp)
        .clip(RoundedCornerShape(16.dp))
        .fillMaxWidth()
        .wrapContentWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .border(BorderStroke(2.dp, grey700), shape = RoundedCornerShape(16.dp))
                    .background(
                        grey800,
                        RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ){

                Column (
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    verticalArrangement = Arrangement.Center
                ){
                    if (bmi.toDouble() != 0.0){
                        Text(text = "Your BMI is ", fontSize = 15.sp, color = Color.White)

                        Spacer(modifier = Modifier.height(15.dp))

                        Row (verticalAlignment = Alignment.Top){
                            Text(text = bmi, color = Color(0xFF00B0FF), fontSize = 60.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = cat,
                                color =
                                when (cat) {
                                    "Underweight" -> {
                                        Color(0xFF18FFFF)
                                    }

                                    "Normal" -> {
                                        Color(0xFF00E676)
                                    }
                                    else -> {
                                        Color(0xFFFF1744)
                                    }
                                },
                                fontSize = 15.sp
                            )
                        }
                        Text(text = "kg / m²", color = grey200, fontSize = 15.sp)
                        Spacer(modifier = Modifier.height(30.dp))
                        Row (
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(horizontal = 5.dp)
                            ){
                                Text(text = "Underweight", color = Color(0xFF18FFFF), fontSize = 13.sp)
                                Box (modifier = Modifier
                                    .padding(5.dp)
                                    .background(Color(0xFF18FFFF), RoundedCornerShape(5.dp))
                                    .padding(4.5.dp)
                                    .width(80.dp))
                                Text(text = "(16.5 - 18.5)", fontSize = 12.sp, color = grey300)
                            }
                            Column(

                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(horizontal = 5.dp)
                            ){
                                Text(text = "Normal", color = Color(0xFF00E676), fontSize = 13.sp)
                                Box (modifier = Modifier
                                    .padding(5.dp)
                                    .background(Color(0xFF00E676), RoundedCornerShape(5.dp))
                                    .padding(4.5.dp)
                                    .width(80.dp))
                                Text(text = "(18.5 - 25)", fontSize = 12.sp, color = grey300)

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(horizontal = 5.dp)
                            ){
                                Text(text = "Overweight", color = Color(0xFFFF1744), fontSize = 13.sp)
                                Box (
                                    Modifier
                                        .padding(5.dp)
                                        .background(Color(0xFFFF1744), RoundedCornerShape(5.dp))
                                        .padding(4.5.dp)
                                        .width(80.dp))
                                Text(text = "(25 & above)", fontSize = 12.sp, color = grey300)

                            }
                        }
                    }
                    else{
                        Text(text = cat, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 25.sp, modifier = Modifier.padding(16.dp))
                    }
                }
            }
    }
}
private fun calculate(weight: Double, height: Double): List<String>{
    return try {
        val bmi = (weight / (height * height))
        val cat = when (bmi){
            in 16.5..18.5 -> "UnderWeight"
            in 18.5..25.0 -> "Normal"
            else -> "Overweight"
        }
        listOf(String.format("%.2f", bmi), cat)
    }catch (e: Exception){
        listOf("22.9", "Normal")
    }

}