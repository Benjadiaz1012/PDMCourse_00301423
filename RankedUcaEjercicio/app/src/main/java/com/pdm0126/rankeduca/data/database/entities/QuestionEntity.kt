package com.pdm0126.rankeduca.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pdm0126.rankeduca.data.model.Question

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
)

fun QuestionEntity.toModel(): Question {
    return Question(
        id = id,
        title = title,
        optionCount = 0,
    )
}