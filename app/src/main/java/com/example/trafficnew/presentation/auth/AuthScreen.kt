package com.example.trafficnew.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.trafficnew.R
import com.example.trafficnew.presentation.components.BigButton
import com.example.trafficnew.presentation.components.CustomOutlinedTextField
import com.example.trafficnew.presentation.main.MainScreen

class AuthScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val loginTxt = remember {
            mutableStateOf("")
        }
        val passTxt = remember {
            mutableStateOf("")
        }
        val navigator = LocalNavigator.currentOrThrow
        Column(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 25.dp)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                imageVector = ImageVector.vectorResource(if(isSystemInDarkTheme()) R.drawable.logo_dark else R.drawable.logo),
                contentDescription = ""
            )
            Column {
                CustomOutlinedTextField(loginTxt, "Логин")
                Spacer(modifier = Modifier.height(10.dp))
                CustomOutlinedTextField(passTxt, "Пароль", isPass = true)
                Spacer(modifier = Modifier.height(10.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd){
                    Text(text = "Забыли пароль?", color = Color(0xFF5682FF))
                }
            }
            Column(Modifier.offset(y=50.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "Не зарегистрированы?", color = Color(0xFFB8C0C3))
                    Text(text = " Регистрация", color = Color(0xFF5682FF))
                }
                Spacer(modifier = Modifier.height(10.dp))
                BigButton("Войти"){
                    navigator.replace(MainScreen())
                }
            }
        }
    }
}