package com.alcadiosystem.gamermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alcadiosystem.gamermvvmapp.presentation.screans.login.LoginScreen
import com.alcadiosystem.gamermvvmapp.presentation.screans.signup.SignUpScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ){
        composable(route = AppScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AppScreen.Signup.route){
            SignUpScreen(navController)
        }
    }
}