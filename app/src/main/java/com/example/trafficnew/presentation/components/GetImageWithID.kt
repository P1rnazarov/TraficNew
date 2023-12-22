package com.example.trafficnew.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Composable
fun GetImageWithID(imageId: Int, modifier: Modifier? = null, onClick: () -> Unit) {
    if (modifier != null) {
        Image(
            imageVector = ImageVector.vectorResource(imageId),
            contentDescription = "",
            modifier = modifier.clickable { onClick() })
    } else {
        Image(
            imageVector = ImageVector.vectorResource(imageId),
            contentDescription = "",
            modifier = Modifier.clickable { onClick() })
    }
}