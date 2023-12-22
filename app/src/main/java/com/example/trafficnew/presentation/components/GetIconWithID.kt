package com.example.trafficnew.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Composable
fun GetIconWithID(iconId: Int, color: Color, modifier: Modifier? = null) {
    Icon(
        imageVector = ImageVector.vectorResource(iconId),
        contentDescription = "",
        modifier = modifier ?: Modifier,
        tint = color
    )
}