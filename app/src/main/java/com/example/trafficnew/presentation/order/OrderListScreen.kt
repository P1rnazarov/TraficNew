package com.example.trafficnew.presentation.order

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.trafficnew.R
import com.example.trafficnew.presentation.components.CustomTopBar
import com.example.trafficnew.presentation.components.GetIconWithID
import com.example.trafficnew.ui.theme.FontSilver
import com.example.trafficnew.ui.theme.PrimaryGreen
import com.example.trafficnew.ui.theme.PrimaryRed

class OrderListScreen : Screen {
    @Composable
    override fun Content() {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)) {
            CustomTopBar("Cписок заказов", R.drawable.ic_report) {

            }
            Column {
                OrderCard()
                OrderCard()
                OrderCard()
            }
        }
    }

    @Composable
    fun OrderCard() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp)
                .border(
                    width = 2.dp,
                    color = if (false) PrimaryGreen else Color(0xFFA0A2A9),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp), verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Эконом", fontWeight = FontWeight.SemiBold, color = Color(0xFFA0A2A9))
                Text(text = "10 с", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            }
            Row(Modifier.padding(horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                GetIconWithID(iconId = R.drawable.ic_from, color = PrimaryGreen)
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = "Паприка (Меҳмонхонаи Суғдиён)")
                    Text(text = "кӯчаи Мақсудҷон Танбӯрӣ", color = FontSilver)
                }
            }
            Row(Modifier.padding( 10.dp), verticalAlignment = Alignment.CenterVertically) {
                GetIconWithID(iconId = R.drawable.ic_to, color = PrimaryRed)
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = "Паприка (Меҳмонхонаи Суғдиён)")
                    Text(text = "кӯчаи Мақсудҷон Танбӯрӣ", color = FontSilver)
                }
            }
        }
    }
}