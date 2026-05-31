package com.pdm0126.ejerciciopractico.data.api.Posts

import kotlinx.serialization.Serializable


@Serializable
data class PostCreatePosts(
    val title: String,
    val body: String,
    val userId: Int
)
@Serializable
data class PostDTO(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int,
)
