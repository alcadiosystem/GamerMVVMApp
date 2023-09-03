package com.alcadiosystem.gamermvvmapp.presentation.componets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.alcadiosystem.gamermvvmapp.presentation.ui.theme.Red500

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = Red500,
    icon: ImageVector = Icons.Default.ArrowForward,
    enabled:Boolean = true
){
    Button(
        onClick = {onClick()},
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        enabled = enabled
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = text)
        }
    }
}