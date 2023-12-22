package com.example.trafficnew.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trafficnew.R
import com.example.trafficnew.presentation.components.GetImageWithID
import com.example.trafficnew.presentation.order.OrderScreen
import kotlinx.coroutines.launch

class MainScreen : Screen {
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    override fun Content() {
        val status = remember {
            mutableStateOf(false)
        }
        val state = rememberBottomSheetScaffoldState()
        val scope = rememberCoroutineScope()

        val navigator = LocalNavigator.currentOrThrow

        BottomSheetScaffold(
            sheetContent = {
                Row(
                    Modifier
                        .height(110.dp)
                        .padding(horizontal = 25.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        GetImageWithID(R.drawable.ic_order_list) {
                            navigator.push(OrderScreen())
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Text(
                            text = "Не в работе!",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    GetImageWithID(
                        if (status.value) R.drawable.ic_stop else R.drawable.ic_go) {
                        status.value = !status.value
                    }
                }
            },
            sheetPeekHeight = 110.dp,
            sheetGesturesEnabled = false,
            sheetShape = RoundedCornerShape(20.dp),
            drawerContent = {},
            scaffoldState = state,
            drawerGesturesEnabled = state.drawerState.isOpen
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            ) {
                Column(modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 25.dp)) {
                    FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Color.White) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_zoom_in),
                            contentDescription = ""
                        )

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Color.White) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_zoom_out),
                            contentDescription = ""
                        )
                    }
                }
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(bottom = 140.dp, start = 25.dp)
                        .background(
                            MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                    GetImageWithID(imageId = R.drawable.ic_gps) {

                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .align(
                            Alignment.TopCenter
                        )
                        .fillMaxWidth()
                        .padding(25.dp), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .background(
                                MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(15.dp)
                            )
                    ) {
                        GetImageWithID(imageId = R.drawable.gg_menu_left) {
                            scope.launch {
                                state.drawerState.open()
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .width(125.dp)
                            .height(48.dp)
                            .background(
                                MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(15.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "12.6 c",
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .background(
                                MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(15.dp)
                            )
                    ) {
                        GetImageWithID(imageId = R.drawable.ic_person) {

                        }
                    }

                }

            }
        }
    }
}