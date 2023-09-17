package com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.alcadiosystem.gamermvvmapp.domain.model.Response
import com.alcadiosystem.gamermvvmapp.presentation.componets.ProgressBar
import com.alcadiosystem.gamermvvmapp.presentation.screans.profile.profile_edit.ProfileEditViewModel

@Composable
fun Update(viewModel: ProfileEditViewModel = hiltViewModel()) {

    when (val updateResponse = viewModel.updateResponse) {
        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                updateResponse.exception?.message?:"Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            Toast.makeText(
                LocalContext.current,
                "Datos actualizados correctamente",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }

}