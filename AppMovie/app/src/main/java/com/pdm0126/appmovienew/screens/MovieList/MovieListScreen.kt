package com.pdm0126.appmovienew.screens.MovieList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MovieListScreen() {
    Scaffold() { innerPadding ->
        LazyRow(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

        }
    }
}