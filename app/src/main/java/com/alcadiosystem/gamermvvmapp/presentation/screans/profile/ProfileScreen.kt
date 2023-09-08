package com.alcadiosystem.gamermvvmapp.presentation.screans.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navHostController: NavHostController) {
    Scaffold (
        topBar = {},
        content = {
                  Text(text = "ProfileScreen", modifier = Modifier.padding(paddingValues = it))
        },
        bottomBar = {}
    )
}