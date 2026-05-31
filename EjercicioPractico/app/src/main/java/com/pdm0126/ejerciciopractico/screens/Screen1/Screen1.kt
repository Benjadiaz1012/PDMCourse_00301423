package com.pdm0126.ejerciciopractico.screens.Screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Screen1(onBack: () -> Unit, viewModel: Screen1ViewModel = viewModel()) {
    val title by viewModel.title.collectAsState()
    val body by viewModel.body.collectAsState()
    val saving by viewModel.saving.collectAsState()
    val saveMessage by viewModel.saveMessage.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Ingresa abajo el titulo: ", modifier = Modifier.padding(top = 10.dp))
        OutlinedTextField(
            label = { Text("Titulo") },
            value = title,
            onValueChange = { viewModel.onTitleChange(it) },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            label = { Text("Body") },
            value = body,
            onValueChange = { viewModel.onBodyChange(it) },
            modifier = Modifier.fillMaxWidth(),
            minLines = 4
        )
        Button(onClick = { viewModel.CreatePost() }, enabled = !saving) {
            Text(if (saving) "Guardar..." else "Crear Post")
        }
        saveMessage?.let {
            Text(text = it)
        }
    }
}