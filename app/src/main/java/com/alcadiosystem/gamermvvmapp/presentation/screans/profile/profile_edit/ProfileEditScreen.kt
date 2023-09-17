package com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alcadiosystem.gamermvvmapp.presentation.componets.DefaultTopBar
import com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit.components.ProfileEditContent
import com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit.components.Update

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen(
    navController: NavHostController,
    user:String
) {

    Scaffold(
        topBar = {
            Surface(shadowElevation = 10.dp) {
                DefaultTopBar(
                    title = "Editar usuario",
                    upAvailable = true,
                    navController = navController
                )
            }
        },
        content = { innerPadding ->
            ProfileEditContent(navController, innerPadding)
        },
        bottomBar = {}
    )

    Update()
}