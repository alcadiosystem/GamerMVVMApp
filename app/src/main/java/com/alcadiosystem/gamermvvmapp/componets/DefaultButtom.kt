package com.alcadiosystem.gamermvvmapp.componets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.alcadiosystem.gamermvvmapp.ui.theme.Red500

@Composable
fun DefaultButton(
    text:String,
    onClick:()->Unit,
    color: Color = Red500,
    icon: ImageVector = Icons.Default.ArrowForward
){
    Button(
        onClick = {onClick()},
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = text)
        }
    }
}