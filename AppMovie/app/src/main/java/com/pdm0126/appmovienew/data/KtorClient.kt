package com.pdm0126.appmovienew.data

import com.pdm0126.appmovienew.BuildConfig
import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient

object KtorClient {

    private val token = BuildConfig.TMDB_TOKEN
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.d("KtorClient", message)
                }
            }
            level = LogLevel.ALL
        }

        install(DefaultRequest) {
            url(BASE_URL)
            header(HttpHeaders.Accept, "application/json")
            header(HttpHeaders.Authorization, "Bearer $token")
        }
    }
}
