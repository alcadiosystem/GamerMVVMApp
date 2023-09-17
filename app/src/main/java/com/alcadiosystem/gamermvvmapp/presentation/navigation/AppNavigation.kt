package com.alcadiosystem.gamermvvmapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alcadiosystem.gamermvvmapp.presentation.screans.login.LoginScreen
import com.alcadiosystem.gamermvvmapp.presentation.screans.profile.ProfileScreen
import com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit.ProfileEditScreen
import com.alcadiosystem.gamermvvmapp.presentation.screans.signup.SignUpScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreen.Signup.route) {
            SignUpScreen(navController)
        }

        composable(route = AppScreen.Profile.route) {
            ProfileScreen(navController)
        }

        composable(
            route = AppScreen.ProfileEdit.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ) { it ->
            it.arguments?.getString("user")?.let {user->
                ProfileEditScreen(navController = navController, user = user)
            }
        }
    }
}