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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.scientificcalculator.Data.ConversionDataIterms.ConversionFactorTypes
import com.example.scientificcalculator.Navigation.Converters
import com.example.scientificcalculator.R
import com.example.scientificcalculator.ui.theme.grey50
import com.example.scientificcalculator.ui.theme.grey700
import com.example.scientificcalculator.ui.theme.grey800
import com.example.scientificcalculator.ui.theme.grey900

private val numbers = listOf("7", "8", "9", "4", "5", "6", "1", "2", "3", "", "0", ".")
@Composable
fun ConversionUI(
    conversionFactorTypes: List<ConversionFactorTypes>,
    title: String,
    navController: NavController
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
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "To Converters Screen",
                tint = Color.White,
                modifier = Modifier.clickable {
                    navController.navigate(Converters.UnitConverterScreen.route)
                }
            )
            Spacer(modifier = Modifier.width(5.dp))
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
                    onClick = {selected = 1},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                ) {

                    Text(text = title, color = grey50)
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
                    onClick = {selected = 2},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                ) {

                    Text(text = title, color = Color.White)
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
                    textOne = if (textOne.length == 1){
                        "0"
                    }else{
                        textOne.substring(0, textOne.length-1)
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
                                } else {
                                    if (textTwo == "0") textTwo = numbers[it]
                                    else textTwo += numbers[it]
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
}
