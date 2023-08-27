package com.example.scientificcalculator

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.scientificcalculator.ui.theme.ScientificCalculatorTheme
import com.example.scientificcalculator.ui.theme.grey50
import com.example.scientificcalculator.ui.theme.grey500
import com.example.scientificcalculator.ui.theme.grey800
import com.example.scientificcalculator.ui.theme.grey900
import com.example.scientificcalculator.ui.theme.veryDarkGray

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScientificCalculatorTheme {
                val pagerState = rememberPagerState()

                Column(modifier = Modifier.fillMaxSize()){

                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(grey900)
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Row (
                            verticalAlignment = Alignment.CenterVertically,

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
                                imageVector =
                                if (pagerState.currentPage == 1) Icons.Filled.List else Icons.Outlined.List,
                                contentDescription = "More",
                                tint = grey50,
                                modifier = Modifier.size(30.dp)
                            )
                        }
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
