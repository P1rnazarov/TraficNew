package com.example.trafficnew.presentation.order

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trafficnew.R
import com.example.trafficnew.presentation.components.CustomTopBar
import com.example.trafficnew.presentation.components.GetIconWithID

class OrderScreen : Screen {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold() {
            Column(
                Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(0.dp)) {
                CustomTopBar(text = "Заказы", icon = R.drawable.ic_filter){
                    navigator.push(FilterTarifsScreen())
                }

                Spacer(modifier = Modifier.height(25.dp))
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Row(verticalAlignment = Alignment.CenterVertically) {
//                        Box(
//                            modifier = Modifier
//                                .size(50.dp)
//                                .background(Color(0xFFF3F3F3), shape = RoundedCornerShape(100))
//                                .clip(shape = RoundedCornerShape(100)),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Image(
//                                imageVector = ImageVector.vectorResource(R.drawable.ic_order),
//                                contentDescription = ""
//                            )
//                        }
//                        Spacer(modifier = Modifier.width(15.dp))
//                        Text(
//                            text = "Заказы",
//                            style = TextStyle(
//                                fontSize = 22.sp,
//                                fontWeight = FontWeight(600),
//                                color = Color(0xFF1C1C1C),
//                            )
//                        )
//                    }
//                    GetImageWithID(imageId = R.drawable.ic_filter) {
//
//                    }
//                }
                val text = arrayOf(
                    "Ватан",
                    "Бофанда",
                    "Пригород",
                    "Палос",
                    "Кайраккум (Гулистон)",
                    "Межгород",
                    "1-Май",
                    "1-3 мкр",
                    "Дружба народов"
                )
                val size = arrayOf(1, 1, 1, 1, 2, 1, 1, 1, 2)
                val texxx = arrayOf(
                    arrayOf("Ватан", "Бофанда", "Пригород"),
                    arrayOf("Палос", "Кайраккум (Гулистон)"),
                    arrayOf("Межгород 1-Май", "1-3 мкр")
                )
                val texxxSize = arrayOf(arrayOf(1, 1, 1), arrayOf(1, 2), arrayOf(2, 1))

                var k = 0
                Column(Modifier.padding(horizontal = 20.dp)) {
                    texxx.forEachIndexed { inx, it ->
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            it.forEachIndexed { inx2, it2 ->
                                Card(Modifier.weight(1f * texxxSize[inx][inx2])){
                                    navigator.push(OrderListScreen())
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Card(modifier: Modifier, function: () -> Unit) {
    Box(
        modifier = modifier
            .height(88.dp).clickable { function() }
            .padding(5.dp)
            .background(MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(15.dp))
            .padding(10.dp)
    ) {
        Text(
            text = "Все",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = "+4",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.align(
                Alignment.BottomStart
            )
        )
        GetIconWithID(
            iconId = R.drawable.ic_location,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.align(
                Alignment.BottomEnd
            )
        )
    }
}