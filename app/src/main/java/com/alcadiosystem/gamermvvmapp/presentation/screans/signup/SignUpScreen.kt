package com.alcadiosystem.gamermvvmapp.presentation.screans.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alcadiosystem.gamermvvmapp.presentation.componets.DefaultTopBar
import com.alcadiosystem.gamermvvmapp.presentation.screans.signup.component.SignupContent
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen (navController: NavHostController){
    Scaffold (
        topBar = {
                 Surface (shadowElevation = 10.dp){
                     DefaultTopBar(title = "Nuevo usuario", upAvailable = true, navController = navController)
                 }
        },
        content = { innerPadding ->
            SignupContent(navController,innerPadding)
        },
        bottomBar = {}
    )

    SignUp(navController = navController)
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3_XL
)
@Composable
fun SignUpPreview() {
    GamerMVVMAppTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            SignUpScreen(rememberNavController())

        }
    }
}