package com.pdm0126.appmovienew.data.repositories.movieRepositories

import com.pdm0126.appmovienew.data.KtorClient
import com.pdm0126.appmovienew.data.api.movie.GetMovieResponseDTO
import com.pdm0126.appmovienew.data.api.movie.toModel
import com.pdm0126.appmovienew.model.Movie
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class TMBApiRepository : TMBReposiroty {
    override suspend fun getMovies(): Result<List<Movie>> {
        try {
            val response: GetMovieResponseDTO = KtorClient.client.get("movie/popular") {
                parameter("language", "es-ES")
                parameter("page", "1")
            }.body()
            return Result.success(response.results.map { movieDTO -> movieDTO.toModel() })
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}