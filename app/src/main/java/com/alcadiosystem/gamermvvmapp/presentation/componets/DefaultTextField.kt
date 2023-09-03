package com.alcadiosystem.gamermvvmapp.presentation.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.Red700


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField (
    modifier: Modifier,
    value:String,
    label:String,
    icon: ImageVector = Icons.Default.Email,
    onValueChange:(String) -> Unit,
    onValidateField:()->Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText:Boolean = false,
    errorMsg:String = ""
){
    Column {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = {
                onValueChange(it)
                onValidateField() },
            label = { Text(text = label) },
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if(hideText) PasswordVisualTransformation() else VisualTransformation.None,
            singleLine = true,
            maxLines = 1
        )

        Text(text = errorMsg, modifier = Modifier.padding(top = 5.dp), fontSize = 11.sp, color = Red700)
    }
}