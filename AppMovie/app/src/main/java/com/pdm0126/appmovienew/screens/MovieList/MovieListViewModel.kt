package com.pdm0126.appmovienew.screens.MovieList

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.appmovienew.data.repositories.movieRepositories.TMBApiRepository
import com.pdm0126.appmovienew.data.repositories.movieRepositories.TMBReposiroty
import com.pdm0126.appmovienew.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    private val TMBReposiroty: TMBReposiroty = TMBApiRepository()
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            TMBReposiroty.getMovies().onSuccess { movies -> _movies.value = movies }
        }
    }
}