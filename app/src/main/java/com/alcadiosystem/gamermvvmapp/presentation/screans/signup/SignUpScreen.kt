package com.alcadiosystem.gamermvvmapp.presentation.screans.signup

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpScreen (){
    Scaffold (
        topBar = {},
        content = {
                  Text(text = "SignupScreen")
        },
        bottomBar = {}
    )
}