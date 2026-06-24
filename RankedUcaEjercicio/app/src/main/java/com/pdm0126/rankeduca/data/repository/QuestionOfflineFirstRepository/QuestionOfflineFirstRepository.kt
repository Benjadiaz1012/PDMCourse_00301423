package com.pdm0126.rankeduca.data.repository.QuestionOfflineFirstRepository

import com.pdm0126.rankeduca.data.model.Option
import com.pdm0126.rankeduca.data.model.Question
import kotlinx.coroutines.flow.Flow

interface QuestionOfflineFirstRepository {
    fun getQuestions(): Flow<List<Question>>
    fun getOptions(questionId: Int): Flow<List<Option>>

    suspend fun refresh()
    suspend fun createQuestion(text: String)
    suspend fun updateQuestion(id: Int, text: String)
    suspend fun deleteQuestion(id: Int)

    suspend fun createOption(questionId: Int, value: String)
    suspend fun updateOption(id: Int, value: String)
    suspend fun deleteOption(id: Int)
}