package com.alcadiosystem.gamermvvmapp.presentation.screans.profile

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alcadiosystem.gamermvvmapp.presentation.componets.DefaultButton
import com.alcadiosystem.gamermvvmapp.presentation.navigation.AppScreen
import com.alcadiosystem.gamermvvmapp.presentation.screans.profile.components.ProfileContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {},
        content = {
            ProfileContent(navController = navController, viewModel = viewModel)
        },
        bottomBar = {}
    )
}