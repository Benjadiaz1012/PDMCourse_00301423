package com.pdm0126.appmovienew.data.repositories.movieRepositories

import com.pdm0126.appmovienew.model.Movie

interface TMBReposiroty {
    suspend fun getMovies(): Result<List<Movie>>
}