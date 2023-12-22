package com.example.trafficnew.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.trafficnew.R

@Composable
fun RoundCheckBox(isChecked: MutableState<Boolean>) {
    Box(modifier = Modifier
        .size(31.dp)
        .clip(RoundedCornerShape(100))
        .background(MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(100))) {
        if (isChecked.value) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_round_check),
                contentDescription = ""
            )
        }
    }
}