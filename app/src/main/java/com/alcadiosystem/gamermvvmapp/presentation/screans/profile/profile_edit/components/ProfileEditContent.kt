package com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alcadiosystem.gamermvvmapp.R
import com.alcadiosystem.gamermvvmapp.presentation.componets.DefaultButton
import com.alcadiosystem.gamermvvmapp.presentation.componets.DefaultTextField
import com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit.ProfileEditViewModel
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.Darkgray500
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.Red500

@Composable
fun ProfileEditContent(
    navController: NavHostController,
    innerPadding: PaddingValues,
    viewModel: ProfileEditViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Box(
            modifier = Modifier
                .height(230.dp)
                .background(Red500)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                    modifier = Modifier.height(120.dp)
                )
            }
        }

        Card(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 200.dp),
            colors = CardDefaults.cardColors(
                containerColor = Darkgray500
            )
        ) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Text(
                    text = "Editar datos",
                    modifier = Modifier.padding(
                        top = 40.dp,
                        bottom = 0.dp,
                        end = 0.dp,
                        start = 0.dp
                    ),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "Por favor ingresa estos datos para continuar",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = state.username,
                    label = "Nombre de usuario",
                    onValueChange = { viewModel.onUserNameInput(it)},
                    icon = Icons.Filled.Person,
                    errorMsg = viewModel.userNameErrorMsg,
                    onValidateField = { viewModel.validateUserName() }
                )

                Spacer(modifier = Modifier.size(25.dp))

                DefaultButton(
                    text = "Actualizar Datos",
                    onClick = {
                              viewModel.onUpdate()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    icon = Icons.Filled.Edit
                )
                Spacer(modifier = Modifier.size(25.dp))
            }
        }


    }

}

