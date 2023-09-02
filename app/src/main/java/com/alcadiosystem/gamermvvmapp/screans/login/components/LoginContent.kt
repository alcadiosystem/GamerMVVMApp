package com.alcadiosystem.gamermvvmapp.screans.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcadiosystem.gamermvvmapp.R
import com.alcadiosystem.gamermvvmapp.componets.DefaultButton
import com.alcadiosystem.gamermvvmapp.componets.DefaultTextField
import com.alcadiosystem.gamermvvmapp.ui.theme.Darkgray500
import com.alcadiosystem.gamermvvmapp.ui.theme.GamerMVVMAppTheme
import com.alcadiosystem.gamermvvmapp.ui.theme.Red500

@Composable
fun LoginContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BoxHeader()
        CardForm()


    }
}

@Composable
fun BoxHeader() {
    Box(
        modifier = Modifier
            .height(280.dp)
            .background(Red500)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.control),
                contentDescription = null,
                modifier = Modifier.height(130.dp)
            )
            Text(text = "FIREBASE MVVM")
        }
    }
}



@Composable
fun CardForm() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Card(
        modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 200.dp),
        colors = CardDefaults.cardColors(
            containerColor = Darkgray500
        )
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(
                text = "LOGIN",
                modifier = Modifier.padding(
                    top = 40.dp,
                    bottom = 0.dp,
                    end = 0.dp,
                    start = 0.dp
                ),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "Por favor inicia sesion para continuar",
                fontSize = 12.sp,
                color = Color.Gray
            )

            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = email,
                label = "Email",
                onValueChange = { email = it},
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email
            )
            DefaultTextField(
                modifier = Modifier.padding(top = 5.dp),
                value = password,
                label = "Password",
                onValueChange = { password = it},
                icon = Icons.Default.Lock,
                keyboardType = KeyboardType.Password,
                hideText = true
            )

            Spacer(modifier = Modifier.size(45.dp))

            DefaultButton(text = "INICIAR SESSION", onClick = {})
            Spacer(modifier = Modifier.size(25.dp))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3_XL
)
@Composable
fun GreetingPreview() {
    GamerMVVMAppTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            LoginContent()

        }
    }
}
