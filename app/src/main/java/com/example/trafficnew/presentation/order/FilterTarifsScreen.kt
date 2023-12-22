package com.example.trafficnew.presentation.order

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.trafficnew.R
import com.example.trafficnew.presentation.components.BigButton
import com.example.trafficnew.presentation.components.CustomTopBar
import com.example.trafficnew.presentation.components.RoundCheckBox

class FilterTarifsScreen : Screen{
    @Composable
    override fun Content() {
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(0.dp)
                .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                CustomTopBar("Фильтр тарифов", R.drawable.ic_done) {

                }
                LazyColumn(content = {
                    repeat(10){
                        item {
                            val isChecked = remember {
                                mutableStateOf(false)
                            }
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .clickable { isChecked.value = !isChecked.value }
                                .padding(horizontal = 10.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                                Text(text = "Эконом", fontSize = 16.sp)

                                RoundCheckBox(isChecked)
                            }
                        }
                    }
                }, modifier = Modifier.padding(10.dp))
            }
            Box(modifier = Modifier.padding(10.dp)) {
                BigButton(text = "Сохранить") {

                }
            }
        }
    }
}