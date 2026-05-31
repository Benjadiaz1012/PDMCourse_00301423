package com.pdm0126.ejerciciopractico.data.api.Posts

import com.pdm0126.ejerciciopractico.model.Post
import kotlinx.serialization.Serializable

@Serializable
data class GetPostResponses(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun GetPostResponses.toModel(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}