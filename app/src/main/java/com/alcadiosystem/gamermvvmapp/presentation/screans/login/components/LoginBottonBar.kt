package com.alcadiosystem.gamermvvmapp.presentation.screans.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alcadiosystem.gamermvvmapp.presentation.navigation.AppScreen

@Composable
fun LoginBottomBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "No tienes cuenta?", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = AppScreen.Signup.route)
            },
            text = "REGISTRATE AQUI",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
    }
}