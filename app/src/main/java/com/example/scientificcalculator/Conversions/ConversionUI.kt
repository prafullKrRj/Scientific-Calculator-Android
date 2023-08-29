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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import com.example.scientificcalculator.R
import com.example.scientificcalculator.ui.theme.grey200
import com.example.scientificcalculator.ui.theme.grey50
import com.example.scientificcalculator.ui.theme.grey700
import com.example.scientificcalculator.ui.theme.grey800
import com.example.scientificcalculator.ui.theme.grey900
import com.example.scientificcalculator.ui.theme.indigo400
import java.math.BigDecimal

private val numbers = listOf("7", "8", "9", "4", "5", "6", "1", "2", "3", "", "0", ".")


@Composable
fun ConversionUI(
    firstParams: List<ConversionFactorTypes>,
    title: String,
    icon: Painter,
    secondParams: List<ConversionFactorTypes>?
) {
    var selected by remember {
        mutableStateOf(1)
    }
    var textOne by remember {
        mutableStateOf("0")
    }
    var textTwo by remember {
        mutableStateOf("0")
    }
    var showSelectionDialog1 by remember {
        mutableStateOf(false)
    }
    var showSelectionDialog2 by remember {
        mutableStateOf(false)
    }
    var text1 by remember {
        mutableStateOf(firstParams[0].name)
    }
    var text2 by remember {
        mutableStateOf(firstParams[1].name)
    }
    var conversionFactor1 by remember {
        mutableStateOf(firstParams[0].unitFromStandard)
    }
    var conversionFactor2 by remember {
        mutableStateOf(firstParams[1].unitFromStandard)
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
                              showSelectionDialog1 = true
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
                    color = if (selected==1) Color.Yellow else Color.White,
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
                            showSelectionDialog2 = true
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
                    modifier = Modifier.clickable {
                        selected = 2
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
                    if (selected == 1){
                        textOne = if (textOne.length == 1){
                            "0"
                        }else{
                            textOne.substring(0, textOne.length-1)
                        }
                    }else{
                        textTwo = if (textTwo.length == 1){
                            "0"
                        }else{
                            textTwo.substring(0, textTwo.length-1)
                        }
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
                                    if (textOne == "0") textOne = numbers[it]
                                    else textOne += numbers[it]
                                    textTwo = evaluate(
                                        1,
                                        textOne.toDouble(),
                                        textTwo.toDouble(),
                                        conversionFactor1,
                                        conversionFactor2
                                    )
                                } else {
                                    if (textTwo == "0") textTwo = numbers[it]
                                    else textTwo += numbers[it]
                                    textOne = evaluate(
                                        2,
                                        textOne.toDouble(),
                                        textTwo.toDouble(),
                                        conversionFactor1,
                                        conversionFactor2
                                    )
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
    if (showSelectionDialog1){
        SelectionBox(list = firstParams){
            if (it[0] != ""){
                text1 = it[0]
                conversionFactor1 = it[1].toBigDecimal()
                textTwo = evaluate(1, textOne.toDouble(), textTwo.toDouble(), conversionFactor1, conversionFactor2)
            }
            showSelectionDialog1 = false
        }
    }
    if (showSelectionDialog2){
        SelectionBox(list = firstParams){
            if (it[0] != ""){
                text2 = it[0]
                conversionFactor2 = it[1].toBigDecimal()
                textOne = evaluate(2, textOne.toDouble(), textTwo.toDouble(), conversionFactor1, conversionFactor2)
            }
            showSelectionDialog2 = false
        }
    }
}

private fun evaluate(selected: Int, val1: Double, val2: Double, factor1: BigDecimal, factor2: BigDecimal): String{
    var bi1 = val1.toBigDecimal()
    var bi2 = val2.toBigDecimal()
    try {
        return if (selected == 1){
            factor1.multiply(bi1).divide((if (factor2 == BigDecimal("0")) 1 else factor2) as BigDecimal?).toString()
        }else{
            factor2.multiply(bi2).divide((if (factor2 == BigDecimal("0")) 1 else factor2) as BigDecimal?).toString()
        }
    }catch (e: Exception){
        return 0.toString()
    }

}

@Composable
fun SelectionBox(list: List<ConversionFactorTypes>, onclick: (firstParameter: List<String>) -> Unit){
    var index by remember {
        mutableStateOf(0)
    }
    Dialog(onDismissRequest = {

    },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ) {
        LazyColumn(
            modifier = Modifier.padding(14.dp).background(grey200, RoundedCornerShape(16.dp)).padding(start = 16.dp, top = 16.dp)
        ){
            items(list.size){
                Row (
                    modifier = Modifier
                        .clickable {
                            index = it }
                        .fillMaxWidth()
                    , verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(
                        selected = index == it,
                        onClick = {
                                  index = it
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = indigo400)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = list[it].name)
                }
            }
            item{
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                Row (modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp, end = 10.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
                    Button(
                        onClick = {
                            onclick(listOf(""))
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(text = "Cancel", color = grey50)
                    }
                    Button(
                        onClick = {
                            onclick(listOf(list[index].name, list[index].unitFromStandard.toString()))
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(text = "Ok", color = indigo400)
                    }
                }
            }
        }

    }
}