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
import androidx.compose.ui.window.DialogProperties
import com.example.scientificcalculator.R
import com.example.scientificcalculator.ui.theme.onSecondaryContainer
import com.example.scientificcalculator.ui.theme.primary
import com.example.scientificcalculator.ui.theme.primaryContainer
import com.example.scientificcalculator.ui.theme.secondaryContainer
import com.example.scientificcalculator.ui.theme.surface
import com.example.scientificcalculator.ui.theme.tertiary
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.Duration
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.Calendar

// [Age, months, weeks, days, hours, minutes, nextBirthday[mon], nextBirthdayDays]
@Composable
fun AgeConverter(icon: Painter, title: String) {

    var dateOfBirth by remember {
        mutableStateOf(LocalDate.of(2001, 11, 9))
    }
    var currDate by remember {
        mutableStateOf(LocalDate.of(2023, 1, 1))
    }
    var nextBirthday by remember {
        mutableStateOf(getNextBirthday(dateOfBirth, currDate))
    }
    var selected by remember { mutableStateOf(0) }
    var birthdayDetails by remember {
        mutableStateOf(getBdy(dateOfBirth, currDate))
    }
    val dateDialogState = rememberMaterialDialogState()
    var details by remember {
        mutableStateOf(getDetails(dateOfBirth, currDate))
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
                .background(secondaryContainer)
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
                Text(text = "Date of Birth", color = tertiary, fontSize = 18.sp)
                Button(onClick = {
                    selected = 0
                    dateDialogState.show()
                }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), modifier = Modifier.background(Color.Transparent)
                ) {
                    Text (text = dateOfBirth.toString(), color = if (selected == 0) Color.Yellow else primary, fontSize = 18.sp)

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
                Text(text = "Today's Date", color = tertiary, fontSize = 18.sp)
                Button(onClick = {
                    selected = 1
                    dateDialogState.show()
                }, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), modifier = Modifier.background(Color.Transparent)
                ) {
                    Text (text = currDate.toString(), color = if (selected == 1) Color.Yellow else primary, fontSize = 18.sp)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Today's Date")
                }
            }
            Box(modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .weight(.7f)
                .padding(20.dp)
                .border(BorderStroke(2.dp, primaryContainer), shape = RoundedCornerShape(16.dp))
                .background(
                    shape = RoundedCornerShape(16.dp),
                    color = onSecondaryContainer
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
                                append(styledText("Age\n\n", surface, 25))
                                append(birthdayDetails["years"]?.let { styledText(it, Color.Yellow, 35) })
                                append(styledText("   years\n", surface, 18))
                                append(styledText("${birthdayDetails["months"]} months | ${birthdayDetails["days"]} days", surface, 13))
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
                                append(styledText("\n${nextBirthday["months"]} months | ${nextBirthday["days"]} days", surface, 13))
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
                            color = surface,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)){
                        Row (
                            modifier = Modifier.padding(8.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Column (
                                modifier = Modifier.weight(.4775f)
                            ){
                                Text(text = "Years\nMonths\nWeeks\nDays\nHours\nMinutes", fontSize = 18.sp, color = primary)
                            }
                            Divider(
                                Modifier
                                    .weight(.045f)
                                    .padding(horizontal = 5.5.dp)
                                    .width(2.dp)
                                    .height(150.dp)
                            )
                            Column (
                                modifier = Modifier
                                    .weight(.4775f)
                                    .padding(start = 10.dp)
                            ){
                                Text(text = "${details["years"]}\n${details["months"]}\n${details["weeks"]}\n${details["days"]}\n${details["hours"]}\n${details["minutes"]}", fontSize = 18.sp, color = tertiary)
                            }
                        }
                    }
                }
            }
        }
    }
    MaterialDialog (
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "Ok") {
                details = getDetails(dateOfBirth, currDate)
                dateDialogState.hide()
            }
            negativeButton(text = "Cancel")
        },
        backgroundColor = surface,
        properties = DialogProperties(dismissOnClickOutside = false)
    ){

        datepicker(
            initialDate = LocalDate.now(),
            title = "Pick a date"
        ) {
            if (selected == 0){
                dateOfBirth = it
                nextBirthday = getNextBirthday(dateOfBirth, currDate)
                birthdayDetails = getBdy(dateOfBirth, currDate)
            }else{
                currDate = it
                nextBirthday = getNextBirthday(dateOfBirth, currDate)
                birthdayDetails = getBdy(dateOfBirth, currDate)
            }
        }

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
fun getDetails(dob: LocalDate, currDate: LocalDate): HashMap<String, String>{
    val hashMap = hashMapOf<String, String>()
    try {
        val duration = Duration.between(dob.atStartOfDay(), currDate.atStartOfDay())
        val period = Period.between(dob, currDate)

        val hours = duration.toHours()
        val days = ChronoUnit.DAYS.between(dob, currDate)
        val weeks = days / 7
        val months = period.toTotalMonths()
        val years = period.years
        val minutes = duration.toMinutes()
        hashMap["years"] = years.toString()
        hashMap["months"] = months.toString()
        hashMap["weeks"] = weeks.toString()
        hashMap["days"] = days.toString()
        hashMap["hours"] = hours.toString()
        hashMap["minutes"] = minutes.toString()
        return hashMap
    }catch (e: Exception){
        return hashMap
    }
}
private fun getNextBirthday(dob: LocalDate, currDate: LocalDate):  HashMap<String, String>{
    val cd = Calendar.getInstance()
    cd.set(currDate.year, currDate.monthValue, currDate.dayOfMonth)

    val db = Calendar.getInstance()
    db.set(dob.year, dob.monthValue, dob.dayOfMonth)
    val nextBirthday = Calendar.getInstance()


    nextBirthday.set(Calendar.YEAR, cd.get(Calendar.YEAR))
    nextBirthday.set(Calendar.MONTH, db.get(Calendar.MONTH))
    nextBirthday.set(Calendar.DAY_OF_MONTH, db.get(Calendar.DAY_OF_MONTH))

    // If the next birthday is in the past, add one year
    if (nextBirthday.before(cd)) {
        nextBirthday.add(Calendar.YEAR, 1)
    }

    // Calculate the difference in months and days
    var monthsLeft = nextBirthday.get(Calendar.MONTH) - cd.get(Calendar.MONTH)
    val daysLeft = nextBirthday.get(Calendar.DAY_OF_MONTH) - cd.get(Calendar.DAY_OF_MONTH)
    if (monthsLeft < 0) monthsLeft += 12
    val hashMap = hashMapOf<String, String>()
    hashMap["months"] = monthsLeft.toString()
    hashMap["days"] = daysLeft.toString()
    return hashMap
}
private fun getBdy(db: LocalDate, cd: LocalDate): HashMap<String, String>{
    val currentDate = Calendar.getInstance()
    currentDate.set(cd.year, cd.monthValue, cd.dayOfMonth)

    // Set your date of birth (replace with your actual date of birth)
    val dateOfBirth = Calendar.getInstance()
    dateOfBirth.set(Calendar.YEAR, db.year) // Replace with your birth year
    dateOfBirth.set(Calendar.MONTH, db.monthValue) // Replace with your birth month (0-11)
    dateOfBirth.set(Calendar.DAY_OF_MONTH, db.dayOfMonth) // Replace with your birth day

    // Calculate the age
    var years = currentDate.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
    var months = currentDate.get(Calendar.MONTH) - dateOfBirth.get(Calendar.MONTH)
    var days = currentDate.get(Calendar.DAY_OF_MONTH) - dateOfBirth.get(Calendar.DAY_OF_MONTH)

    // Adjust for negative months or days
    if (days < 0) {
        val lastMonth = currentDate.getActualMaximum(Calendar.DAY_OF_MONTH)
        months--
        days += lastMonth
    }
    if (months < 0) {
        years--
        months += 12
    }
    val hashMap = hashMapOf<String, String>()
    hashMap["years"] = years.toString()
    hashMap["months"] = months.toString()
    hashMap["days"] = days.toString()
    return hashMap
}