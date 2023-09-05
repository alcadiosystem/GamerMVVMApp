package com.alcadiosystem.gamermvvmapp.presentation.screans.signup.component

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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alcadiosystem.gamermvvmapp.R
import com.alcadiosystem.gamermvvmapp.presentation.componets.DefaultButton
import com.alcadiosystem.gamermvvmapp.presentation.componets.DefaultTextField
import com.alcadiosystem.gamermvvmapp.presentation.screans.signup.SignupViewModel
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.Darkgray500
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.Red500

@Composable
fun SignupContent(innerPadding: PaddingValues, viewModel:SignupViewModel = hiltViewModel()) {
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
                    text = "REGISTRO",
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
                    value = viewModel.username.value,
                    label = "Nombre de usuario",
                    onValueChange = { viewModel.username.value = it},
                    icon = Icons.Filled.Person,
                    errorMsg = viewModel.userNameErrorMsg.value,
                    onValidateField = {viewModel.validateUserName()}
                )

                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.email.value,
                    label = "Email",
                    onValueChange = { viewModel.email.value = it},
                    icon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.emailErrorMg.value,
                    onValidateField = {viewModel.validateEmail()}
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.password.value,
                    label = "Password",
                    onValueChange = { viewModel.password.value = it},
                    icon = Icons.Default.Lock,
                    keyboardType = KeyboardType.Password,
                    hideText = true,
                    errorMsg = viewModel.passwordErrorMg.value,
                    onValidateField = {viewModel.validatePassword()}
                )
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.confirmPassword.value,
                    label = "Confirmar Password",
                    onValueChange = { viewModel.confirmPassword.value = it},
                    icon = Icons.Outlined.Lock,
                    keyboardType = KeyboardType.Password,
                    hideText = true,
                    errorMsg = viewModel.confirmPasswordErrorMsg.value,
                    onValidateField = {viewModel.validateConfirmPassword()}
                )

                Spacer(modifier = Modifier.size(25.dp))

                DefaultButton(text = "REGISTRARSE", onClick = {}, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.size(25.dp))
            }
        }


    }
}

