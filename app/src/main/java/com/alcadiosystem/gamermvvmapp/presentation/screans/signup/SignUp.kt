package com.alcadiosystem.gamermvvmapp.presentation.screans.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.presentation.componets.ProgressBar
import com.alcadiosystem.gamermvvmapp.presentation.navigation.AppScreen

@Composable
fun SignUp(navController: NavHostController,viewModel:SignupViewModel = hiltViewModel()) {
    when (val signResponse = viewModel.signupResponse) {
        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                signResponse.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                viewModel.createUser()
                navController.popBackStack(AppScreen.Login.route,true)
                navController.navigate(route = AppScreen.Profile.route)
            }
        }

        null -> {}
    }
}