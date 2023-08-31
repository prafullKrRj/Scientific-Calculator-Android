package com.example.scientificcalculator.Conversions.UnirConverterUIs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scientificcalculator.R
import com.example.scientificcalculator.ui.theme.grey100
import com.example.scientificcalculator.ui.theme.grey200
import com.example.scientificcalculator.ui.theme.grey50
import com.example.scientificcalculator.ui.theme.grey500
import com.example.scientificcalculator.ui.theme.grey600
import com.example.scientificcalculator.ui.theme.grey700


@Composable
fun AgeConverter(icon: Painter, title: String) {
    var dateOfBirth by remember {
        mutableStateOf("26-08-2023")
    }
    var currDate by remember {
        mutableStateOf("26-08-2023")
    }
    var selected by remember { mutableStateOf(0) }
    var selectDate by remember {
        mutableStateOf(false)
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = icon,
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                color = Color.White,
                fontSize = 22.sp
            )
        }
        Column(
            modifier = Modifier
                .background(grey700)
                .padding(vertical = 15.dp)
                .weight(.5f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 13.dp)
                    .padding(horizontal = 16.dp)
                    .weight(.15f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Date of Birth", color = grey100, fontSize = 18.sp)
                Button(onClick = {
                    selected = 0
                    selectDate = true
                }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), modifier = Modifier.background(Color.Transparent)
                ) {
                    Text (text = dateOfBirth, color = if (selected == 0) Color.Yellow else grey50, fontSize = 18.sp)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "DOB selector")
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 13.dp)
                    .padding(horizontal = 16.dp)
                    .weight(.15f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Today's Date", color = grey100, fontSize = 18.sp)
                Button(onClick = {
                                 selected = 1
                }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), modifier = Modifier.background(Color.Transparent)
                ) {
                    Text (text = currDate, color = if (selected == 1) Color.Yellow else grey50, fontSize = 18.sp)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Today's Date")
                }
            }
            Box(modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .weight(.7f)
                .padding(20.dp)
                .border(BorderStroke(2.dp, grey600), shape = RoundedCornerShape(16.dp))
                .background(
                    shape = RoundedCornerShape(16.dp),
                    color = grey500
                )){
                Column (
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Column (
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .weight(.4775f)
                                .padding(start = 4.dp)
                        ){
                            Text(text = buildAnnotatedString {
                                append(styledText("Age\n\n", grey200, 25))
                                append(styledText("13", Color.Yellow, 35))
                                append(styledText("   years\n", grey200, 18))
                                append(styledText("0 months | 15 days", grey200, 13))
                            })
                        }
                        Divider(
                            modifier = Modifier
                                .weight(.045f)
                                .padding(horizontal = 6.dp)
                                .width(2.dp)
                                .height(100.dp)
                        )
                        Column (
                            modifier = Modifier.weight(.4775f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            Text(text = buildAnnotatedString {
                                append(styledText("Next Birthday\n", Color.Yellow, 16))
                            })
                            Icon(
                                painter = painterResource(id = R.drawable.birthday_cake),
                                contentDescription = "Cake Icon",
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
                            )
                            Text(text = buildAnnotatedString {
                                append(styledText("Friday\n", grey200, 16))
                                append(styledText("11 months | 16 days", grey200, 13))
                            })
                        }
                    }
                    Divider(Modifier.padding(vertical = 16.dp))

                    Text(text = styledText("Details", Color.Yellow, 16), Modifier.padding(bottom = 8.dp))

                    Box(modifier = Modifier
                        .background(
                            color = Color.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = grey200,
                            shape = RoundedCornerShape(8.dp)
                        ).padding(8.dp)){
                        Row (
                            modifier = Modifier.padding(8.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Column (
                                modifier = Modifier.weight(.4775f)
                            ){
                                Text(text = "Years\nMonths\nWeeks\nDays\nHours\nMinutes", fontSize = 18.sp, color = grey50)
                            }
                            Divider(
                                Modifier
                                    .weight(.045f)
                                    .padding(horizontal = 5.5.dp)
                                    .width(2.dp)
                                    .height(150.dp)
                            )
                            Column (
                                modifier = Modifier.weight(.4775f).padding(start = 10.dp)
                            ){
                                Text(text = "Years\nMonths\nWeeks\nDays\nHours\nMinutes", fontSize = 18.sp, color = grey50)
                            }
                        }
                    }
                }
            }
        }
    }
    if (selectDate){
        DateSelector()
    }
}

fun styledText(text: String, color: Color, size: Int): AnnotatedString{
    return buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = color,
                fontSize = size.sp
            )
        ){
            append(text)
        }
    }
}
@Composable
fun DateSelector() {
    
}