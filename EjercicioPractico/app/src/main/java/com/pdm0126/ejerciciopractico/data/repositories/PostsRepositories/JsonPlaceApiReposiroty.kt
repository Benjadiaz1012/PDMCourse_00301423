package com.pdm0126.ejerciciopractico.data.repositories.PostsRepositories

import android.util.Log
import com.pdm0126.ejerciciopractico.data.api.KtorClient
import com.pdm0126.ejerciciopractico.data.api.Posts.GetPostResponses
import com.pdm0126.ejerciciopractico.data.api.Posts.PostCreatePosts
import com.pdm0126.ejerciciopractico.data.api.Posts.PostDTO
import com.pdm0126.ejerciciopractico.data.api.Posts.toModel
import com.pdm0126.ejerciciopractico.model.Post
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType


class JsonPlaceApiReposiroty : JsonPlaceholderRepositorie {
    override suspend fun getPosts(): Result<List<Post>> {
        try {
            val response: List<GetPostResponses> = KtorClient.client.get("posts") {

            }.body()
            return Result.success(response.map { GetPostResponses -> GetPostResponses.toModel() })
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun createPosts(
        title: String,
        body: String
    ): Result<PostDTO> {
        try {
            val request = PostCreatePosts(
                title = title,
                body = body,
                userId = 1
            )
            val response: PostDTO = KtorClient.client.post("posts") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }.body()
            return Result.success(response)
        } catch (e: Exception) {
            Log.e("PostRepository", "Error al crear el post: ${e.message}")
            return Result.failure(e)
        }
    }
}