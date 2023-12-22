package com.example.trafficnew.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trafficnew.R

@Composable
fun CustomTopBar(text: String, icon: Int, function: () -> Unit) {
    val navigator = LocalNavigator.currentOrThrow
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navigator.pop() }) {
            GetIconWithID(
                iconId = R.drawable.ic_back,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Text(text = text, fontSize = 20.sp)
        IconButton(onClick = { function() }) {
            GetIconWithID(
                iconId = icon,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}