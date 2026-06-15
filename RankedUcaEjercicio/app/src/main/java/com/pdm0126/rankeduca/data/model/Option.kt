package com.pdm0126.rankeduca.data.model

import com.pdm0126.rankeduca.data.database.entities.OptionEntity

data class Option(
    val id: Int = 0,
    val name: String,
    val imageUrl: String,
    val questionId: Int = 0,
)
fun Option.toEntity(): OptionEntity {
    return OptionEntity(
        id = id,
        name = name,
        imageUrl = imageUrl,
        questionId = questionId,
    )
}