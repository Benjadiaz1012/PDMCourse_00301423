package com.pdm0126.rankeduca.data.repository

import com.pdm0126.rankeduca.data.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuesitons(): Flow<List<Question>>
    suspend fun addQuestion(title: String)
    suspend fun deleteQuesiton(question: Question)
}