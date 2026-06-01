package com.pdm0126.appmovienew.screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pdm0126.appmovienew.R


@Composable
fun HomeScreen(onNext: () -> Unit) {
    Scaffold() { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Banner(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )
                Button(onClick = { onNext() }) { Text(text = "Pasar a lista de Peliculas") }
            }
        }
    }
}

@Composable
fun Banner(modifier: Modifier) {
    val banner = painterResource(R.drawable.banner_app_asset)
    Image(
        painter = banner,
        contentDescription = "Bienvenido a TMDB",
        modifier = modifier,
    )
}