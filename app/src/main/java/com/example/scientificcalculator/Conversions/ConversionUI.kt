package com.example.scientificcalculator.Conversions

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import com.example.scientificcalculator.R
import com.example.scientificcalculator.ui.theme.grey50
import com.example.scientificcalculator.ui.theme.grey700
import com.example.scientificcalculator.ui.theme.grey800
import com.example.scientificcalculator.ui.theme.grey900
import java.math.BigDecimal

val numbers = listOf("7", "8", "9", "4", "5", "6", "1", "2", "3", "", "0", ".")


@Composable
fun ConversionUI(
    firstParams: List<ConversionFactorTypes>,
    title: String,
    icon: Painter,
    secondParams: List<ConversionFactorTypes>?
) {

    var textOne by rememberSaveable {
        mutableStateOf("0")
    }
    var textTwo by rememberSaveable {
        mutableStateOf("0")
    }

    var text1 by remember {
        mutableStateOf(firstParams[0].name)
    }
    var text2 by remember {
        mutableStateOf(firstParams[1].name)
    }
    var conversionFactor1 by rememberSaveable {
        mutableStateOf(0)
    }
    var conversionFactor2 by rememberSaveable {
        mutableStateOf(1)
    }
    var selected by remember {
        mutableStateOf(1)
    }
    var showSelectionDialogFrom by remember {
        mutableStateOf(false)
    }
    var showSelectionDialogTo by remember {
        mutableStateOf(false)
    }
    var isClicked1 by remember {
        mutableStateOf(true)
    }
    var isClicked2 by remember {
        mutableStateOf(true)
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
                              showSelectionDialogFrom = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                ) {

                    Text(text = text1, color = grey50)
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
                    modifier = Modifier.clickable { selected = 1 }
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
                            showSelectionDialogTo = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                ) {

                    Text(text = text2, color = Color.White)
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
                    modifier = Modifier.clickable { selected = 2 }
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
                        textTwo = eval(
                            textOne,
                            firstParams[conversionFactor1].unitFromStandard, firstParams[conversionFactor2].unitFromStandard
                        )
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
                    tint = grey50)

            }
        }
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
                            .background(if (numbers[it] != "") grey800 else grey900, CircleShape)
                    }else{
                        Modifier
                            .size(100.dp)
                            .padding(6.dp)
                            .background(if (numbers[it] != "") grey800 else grey900, CircleShape)
                            .clip(CircleShape)
                            .clickable {
                                if (selected == 1) {
                                    isClicked2 = true
                                    if (textOne == "0"){
                                        textOne = ""
                                        isClicked1 = false
                                        textOne += numbers[it]
                                        textTwo = eval(
                                            textOne,
                                            firstParams[conversionFactor1].unitFromStandard,
                                            firstParams[conversionFactor2].unitFromStandard
                                        )
                                    }else {
                                        if (isClicked1) {
                                            textOne = ""
                                            isClicked1 = false
                                        }
                                        textOne += numbers[it]
                                        textTwo = eval(
                                            textOne,
                                            firstParams[conversionFactor1].unitFromStandard,
                                            firstParams[conversionFactor2].unitFromStandard
                                        )
                                    }
                                } else {
                                    isClicked1 = true
                                    if (textTwo == "0"){
                                        textTwo = ""
                                        isClicked2 = false
                                        textTwo += numbers[it]
                                        textOne = eval(
                                            textTwo,
                                            firstParams[conversionFactor2].unitFromStandard,
                                            firstParams[conversionFactor1].unitFromStandard
                                        )
                                    }else {
                                        if (isClicked2 == true) {
                                            textTwo = ""
                                            isClicked2 = false
                                        }
                                        textTwo += numbers[it]
                                        textOne = eval(textTwo, firstParams[conversionFactor1].unitFromStandard, firstParams[it].unitFromStandard)
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
        if (showSelectionDialogFrom){
            SelectionBox(list = firstParams){
                if (it.isNotEmpty()){
                    text1 = it[0]
                    conversionFactor1 = it[1].toInt()
                    if (selected == 1){
                        textTwo = eval(textOne, firstParams[conversionFactor1].unitFromStandard, firstParams[conversionFactor2].unitFromStandard)
                    }else{
                        textOne = eval(textTwo, firstParams[conversionFactor2].unitFromStandard, firstParams[conversionFactor1].unitFromStandard)
                    }
                }
                showSelectionDialogFrom = false
            }
        }
        if (showSelectionDialogTo){
            SelectionBox(list = firstParams){
                if (it.isNotEmpty()) {
                    text2 = it[0]
                    conversionFactor2 = it[1].toInt()
                    if (selected == 1){
                        textTwo = eval(textOne, firstParams[conversionFactor1].unitFromStandard, firstParams[conversionFactor2].unitFromStandard)
                    }else{
                        textOne = eval(textTwo, firstParams[conversionFactor2].unitFromStandard, firstParams[conversionFactor1].unitFromStandard)
                    }
                }
                showSelectionDialogTo = false
            }
        }
    }
}

private fun eval(fromValue: String, conversionFactor1: BigDecimal, conversionFactor2: BigDecimal): String{
    return try {
        val f = fromValue.toDouble()
        val cf1 = conversionFactor1.toString().toDouble()
        val cf2 = conversionFactor2.toString().toDouble()
        (f * cf1 / cf2).toString()
    }catch (e: Exception){
        "1"
    }
}
