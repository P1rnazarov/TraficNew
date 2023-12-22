package com.example.trafficnew.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.trafficnew.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(stateTxt: MutableState<String>, placeholderTxt: String, isPass: Boolean = false) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = stateTxt.value,
        onValueChange = { stateTxt.value = it },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xFFB8C0C3),
            focusedBorderColor = Color(0xFFB8C0C3)
        ),
        placeholder = { Text(text = placeholderTxt, color = Color(0xFFB8C0C3)) },
        trailingIcon = {
            if(isPass){
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(imageVector = ImageVector.vectorResource(R.drawable.ic_eye_invisible_outlined), contentDescription = "")
                        if(passwordVisibility) Image(imageVector = ImageVector.vectorResource(R.drawable.ic_eye_lined), contentDescription = "")
                    }
                }
            }
        },
        visualTransformation = if (!passwordVisibility && isPass)  PasswordVisualTransformation() else VisualTransformation.None ,
    )
}