package com.alcadiosystem.gamermvvmapp.presentation.componets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alcadiosystem.gamermvvmapp.presentation.screans.signup.SignUpScreen
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.Red500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navController: NavHostController? = null,
    color: Color = Red500
) {
    TopAppBar(
        title = { Text(text = title, fontSize = 19.sp) },
        actions = {},
        navigationIcon = {
            if (upAvailable) IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = color
        )
    )
}


@Preview(
    showBackground = true,
)
@Composable
fun TopBarPreview() {
    GamerMVVMAppTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            DefaultTopBar("Prubea")

        }
    }
}