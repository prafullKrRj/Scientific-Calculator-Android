package com.example.scientificcalculator.Conversions


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scientificcalculator.Conversions.UnirConverterUIs.AgeConverter
import com.example.scientificcalculator.Conversions.UnirConverterUIs.AreaC
import com.example.scientificcalculator.Conversions.UnirConverterUIs.BMI
import com.example.scientificcalculator.Conversions.UnirConverterUIs.DataConverter
import com.example.scientificcalculator.Conversions.UnirConverterUIs.LengthConverter
import com.example.scientificcalculator.Conversions.UnirConverterUIs.MassConverter
import com.example.scientificcalculator.Conversions.UnirConverterUIs.NumeralSystem
import com.example.scientificcalculator.Conversions.UnirConverterUIs.SpeedConverter
import com.example.scientificcalculator.Conversions.UnirConverterUIs.TemperatureConverter
import com.example.scientificcalculator.Conversions.UnirConverterUIs.TimeConverter
import com.example.scientificcalculator.Conversions.UnirConverterUIs.VolumeConverter
import com.example.scientificcalculator.Data.ConversionDataItems.UnitConversionItems
import com.example.scientificcalculator.Data.ScreenCompatibility.WindowInfo
import com.example.scientificcalculator.Data.ScreenCompatibility.rememberWindowInfo
import com.example.scientificcalculator.Navigation.Converters
import com.example.scientificcalculator.R
import com.example.scientificcalculator.ui.theme.tertiaryContainer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun UnitConverterScreen() {

    val navController = rememberNavController()
    val list = listOf(
        UnitConversionItems(painterResource(id = R.drawable.age), "Age"),
        UnitConversionItems(painterResource(id = R.drawable.area), "Area"),
        UnitConversionItems(painterResource(id = R.drawable.bmi), "BMI"),
        UnitConversionItems(painterResource(id = R.drawable.weight), "Mass"),
        UnitConversionItems(painterResource(id = R.drawable.mobile_data), "Data"),
        UnitConversionItems(painterResource(id = R.drawable.length), "Length"),
        UnitConversionItems(painterResource(id = R.drawable.number_1), "Numeral System"),
        UnitConversionItems(painterResource(id = R.drawable.download_speed), "Speed"),
        UnitConversionItems(painterResource(id = R.drawable.thermometer), "Temperature"),
        UnitConversionItems(painterResource(id = R.drawable.cylinder), "Volume"),
        UnitConversionItems(painterResource(id = R.drawable.clock), "Time")
    )
    val coroutineScope = rememberCoroutineScope()

    NavHost(navController = navController, startDestination = "unit_converter_main_screen"){
        composable("unit_converter_main_screen" ){
            val windowInfo = rememberWindowInfo()
            var columns by remember{
                mutableStateOf(2)
            }
            columns = if (windowInfo.screenWidthInfo == WindowInfo.WindowType.Compact){
                2
            }else{
                4
            }
            LazyVerticalGrid(columns = GridCells.Fixed(columns), modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()){
                items(list.size){ idx ->
                    Items(unitConversionItem = list[idx], navController = navController, coroutineScope)
                }
            }
        }
        composable(Converters.Age.route){
            AgeConverter(list[0].icon, list[0].title)
        }
        composable(Converters.Area.route){
            AreaC(list[1].icon, list[1].title)
        }
        composable(Converters.BMI.route){
            BMI(list[2].icon, list[2].title)
        }
        composable(Converters.Mass.route){
            MassConverter(list[3].icon, list[3].title)
        }
        composable(Converters.Data.route){
            DataConverter(list[4].icon, list[4].title)
        }
        composable(Converters.Length.route){
            LengthConverter(list[5].icon, list[5].title)
        }
        composable(Converters.NumeralSystem.route){
            NumeralSystem(list[6].icon, list[6].title)
        }
        composable(Converters.Speed.route){
            SpeedConverter(list[7].icon, list[7].title)
        }
        composable(Converters.Temperature.route){
            TemperatureConverter(list[8].icon, list[8].title)
        }
        composable(Converters.Volume.route){
            VolumeConverter(list[9].icon, list[9].title)
        }
        composable(Converters.Time.route){
            TimeConverter(list[10].icon, list[10].title)
        }

    }

}


@Composable
fun Items(unitConversionItem: UnitConversionItems, navController: NavController, coroutineScope: CoroutineScope) {
    Button(
        onClick = {
            coroutineScope.launch {
                delay(20)
                navController.navigate(unitConversionItem.title)
            }
        },
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .aspectRatio(1f)
            .background(color = tertiaryContainer, shape = CircleShape),
        colors = ButtonDefaults.buttonColors(containerColor = tertiaryContainer)
        ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            Icon(
                painter = unitConversionItem.icon,
                contentDescription = unitConversionItem.title,
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = unitConversionItem.title,
                color = Color.White
            )
        }
    }
}