package com.pdm0126.ejerciciopractico.data.repositories.PostsRepositories

import com.pdm0126.ejerciciopractico.data.api.Posts.PostDTO
import com.pdm0126.ejerciciopractico.model.Post
import okhttp3.FormBody

interface JsonPlaceholderRepositorie {
    suspend fun getPosts(): Result<List<Post>>
    suspend fun createPosts(
        title: String,
        body: String,
    ): Result<PostDTO>
}