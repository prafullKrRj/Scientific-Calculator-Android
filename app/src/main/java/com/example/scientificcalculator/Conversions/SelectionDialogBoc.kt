package com.example.scientificcalculator.Conversions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.scientificcalculator.Data.ConversionDataItems.ConversionFactorTypes
import com.example.scientificcalculator.ui.theme.surface
import com.example.scientificcalculator.ui.theme.tertiaryContainer
import com.example.scientificcalculator.ui.theme.inversionPrimary

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
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 10.dp)
                .background(surface, RoundedCornerShape(16.dp))
                .padding(top = 10.dp)
        ){
            items(list.size){
                Row (
                    modifier = Modifier
                        .clickable {
                            index = it
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp)
                    , verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(
                        selected = index == it,
                        onClick = {
                            index = it
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = inversionPrimary)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = list[it].name)
                }
            }
            item{
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
                    Button(
                        onClick = {
                            onclick(listOf())
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(text = "Cancel", color = tertiaryContainer)
                    }
                    Button(
                        onClick = {
                            onclick(listOf(list[index].name, index.toString()))
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text(text = "Ok", color = inversionPrimary)
                    }
                }
            }
        }

    }
}