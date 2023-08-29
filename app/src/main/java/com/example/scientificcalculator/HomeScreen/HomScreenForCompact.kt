package com.example.scientificcalculator.HomeScreen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scientificcalculator.Data.HomeScreenDataItems.ButtonFeature
import com.example.scientificcalculator.Data.HomeScreenDataItems.GetButtonList
import com.example.scientificcalculator.ui.theme.grey800
import com.example.scientificcalculator.ui.theme.grey900
import com.example.scientificcalculator.R
import com.faendir.rhino_android.RhinoAndroidHelper
import org.mozilla.javascript.ImporterTopLevel


private val compactList = GetButtonList().compactButtonList()
private val nonCompactList = GetButtonList().nonCompactButtonList()
private val extraButtonsList = GetButtonList().getExtraButton()

@Composable
fun ForCompact() {
    Column(
        modifier = Modifier
            .background(grey900)
            .fillMaxSize()
    ) {

        var columns by remember{
            mutableStateOf(4)
        }
        var itemCount by remember {
            mutableStateOf(compactList.size)
        }
        var buttonList by remember {
            mutableStateOf(compactList)
        }
        var isCompact by remember {
            mutableStateOf(true)
        }

        var isVisibleExtraFunction by remember {
            mutableStateOf(false)
        }

        var upperText by remember {
            mutableStateOf("")
        }
        var lowerText by remember {
            mutableStateOf("")
        }
        var isEvaluated by remember { mutableStateOf(false) }

        var isBracketed by remember { mutableStateOf(false) }

        if (isEvaluated){
            upperText = eval(upperText)
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(if (isVisibleExtraFunction) .28f else .33f),
        ){
            Text(text = upperText, fontSize = 30.sp, color = Color.White, modifier = Modifier.align(
                Alignment.End
            ))
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "= $lowerText", fontSize = 23.sp, color = Color.LightGray, modifier = Modifier.align(
                Alignment.End
            ))
        }
        Spacer(modifier = Modifier.height(5.dp))
        IconButton(onClick = {
            isVisibleExtraFunction = !isVisibleExtraFunction
        }) {
            Icon(
                imageVector = if (isVisibleExtraFunction) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "extra functions toggle Button",
                tint = Color.White
            )
        }

        if (isVisibleExtraFunction){

            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier
                    .weight(.23f)
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 450,
                            easing = FastOutSlowInEasing
                        )
                    )
                    .fillMaxWidth()
                    .background(grey800),
                contentPadding = PaddingValues(
                    16.dp,
                    8.dp,
                    16.dp
                )
            ) {
                items(extraButtonsList.size){
                    ExtraButtons(it = it){ str ->
                        when (str){
                            "()" -> {
                                upperText += if (isBracketed) ")" else "("
                                isBracketed = !isBracketed
                            }
                            "e" -> upperText += "e"
                            "sin x" -> upperText += "sin("
                            "cos x" -> upperText += "cos("
                            "tan x" -> upperText += "tan("
                            "sin-1 x" -> upperText += "sin-1("
                            "cos-1 x" -> upperText += "sin-1("
                            "tan-1 x" -> upperText += "sin-1("
                            else ->{
                                upperText += "$str("
                            }
                        }
                        lowerText = upperText
                    }
                }
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            contentPadding = PaddingValues(start = 16.dp, bottom = 16.dp, end = 16.dp, top = 8.dp),
            modifier = Modifier
                .background(grey800)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = FastOutLinearInEasing
                    )
                )
        ) {
            items(itemCount) { index ->
                Buttons(buttonFeature = buttonList[index]){

                    if (it == ""){
                        if (isCompact){
                            columns = 5
                            itemCount = nonCompactList.size
                            buttonList = nonCompactList
                            isCompact = false
                        }
                        else{
                            columns = 4
                            itemCount = compactList.size
                            buttonList = compactList
                            isCompact = true
                        }
                    }else{
                        when (it){
                            "AC" -> upperText = ""
                            "X" -> upperText = if (upperText != "") upperText.substring(0, upperText.length-1) else ""
                            "=" -> isEvaluated = true
                            "1/x" -> upperText += "^(-1)"
                            "x!" -> upperText += "!"
                            "√x" -> upperText += "√"
                            else ->{
                                upperText += it
                            }
                        }
                    }
                    lowerText = eval(upperText)
                }
            }
        }
    }
}
fun eval(expression: String) : String{
    if (!expression.isEmpty()){
        var finalResult: String = expression
        val rhinoAndroidHelper = RhinoAndroidHelper()
        val context = rhinoAndroidHelper.enterContext()
        val scope = ImporterTopLevel(context)
        try {
            context.optimizationLevel
            val res = context.evaluateString(scope, expression, "Javascript", 1, null)
            finalResult = res.toString()
        }catch (e: Exception){
            finalResult
        }
        return finalResult
    }
    return expression
}
@Composable
fun ExtraButtons(it: Int, onButtonClick: (string: String) -> Unit) {
    Button(
        onClick = {
            onButtonClick(extraButtonsList[it].buttonText)
        },
        modifier = Modifier
            .width(100.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
            .padding(3.dp),
        colors = ButtonDefaults.buttonColors(containerColor = extraButtonsList[it].buttonColor)
    ) {
        Text(text = extraButtonsList[it].buttonText, fontSize = 18.sp, color = Color.White)
    }
}

@Composable
fun Buttons(buttonFeature: ButtonFeature, onButtonClick : (string: String) -> Unit){
    Button(
        onClick = {
            onButtonClick(buttonFeature.buttonText)
        },
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .padding(5.dp)
            .aspectRatio(1f)
            .background(color = grey800, shape = CircleShape),
        colors = ButtonDefaults.buttonColors(containerColor = buttonFeature.buttonColor)
    ){
        if (buttonFeature.buttonText == "X"){
            Icon(
                painter = painterResource(id = R.drawable.delete),
                contentDescription = "delete",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }else{
            Text(
                text = buttonFeature.buttonText,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        if (buttonFeature.buttonText == ""){
            Icon(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "more",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
