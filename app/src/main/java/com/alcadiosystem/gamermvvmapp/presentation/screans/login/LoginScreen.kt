package com.alcadiosystem.gamermvvmapp.presentation.screans.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alcadiosystem.gamermvvmapp.presentation.screans.login.components.LoginBottomBar
import com.alcadiosystem.gamermvvmapp.presentation.screans.login.components.LoginContent
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {

    val viewModel = LoginViewModel()

    Scaffold(
        topBar = {},
        bottomBar = {
            LoginBottomBar(navController)
        },
        content = {
            LoginContent(viewModel)
        }
    )
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

            LoginScreen(rememberNavController())

        }
    }
}