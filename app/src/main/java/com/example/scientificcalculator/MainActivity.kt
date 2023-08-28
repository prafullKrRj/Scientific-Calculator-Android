package com.example.scientificcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.scientificcalculator.Conversions.UnitConverterScreen
import com.example.scientificcalculator.HomeScreen.HomeScreen
import com.example.scientificcalculator.ui.theme.ScientificCalculatorTheme
import com.example.scientificcalculator.ui.theme.grey50
import com.example.scientificcalculator.ui.theme.grey900

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScientificCalculatorTheme {
                val pagerState = rememberPagerState()

                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(grey900)){


                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                        ){
                        Icon(
                            imageVector =
                            if (pagerState.currentPage == 0) Icons.Filled.Home else Icons.Outlined.Home,
                            contentDescription = "Home",
                            tint = grey50,
                            modifier = Modifier.size(30.dp)

                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Icon(
                            if (pagerState.currentPage == 1) painterResource(id = R.drawable.top_bar_2) else painterResource(
                                id = R.drawable.top_bar_1,

                            ),
                            "More",
                            Modifier.size(25.dp),
                            grey50
                        )
                        
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "About", tint = Color.White)
                    }

                    HorizontalPager(
                        pageCount = 2,
                        state = pagerState
                    ) { index ->
                        when (index){
                            0 -> HomeScreen()
                            else -> UnitConverterScreen()
                        }
                    }
                }
            }
        }
    }
}
