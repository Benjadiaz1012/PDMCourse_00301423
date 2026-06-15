package com.pdm0126.rankeduca.data.repository

import com.pdm0126.rankeduca.data.database.dao.QuestionDao
import com.pdm0126.rankeduca.data.database.entities.QuestionEntity
import com.pdm0126.rankeduca.data.database.entities.toModel
import com.pdm0126.rankeduca.data.model.Question
import com.pdm0126.rankeduca.data.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuestionRepositoryImpl(
    private val questionDao: QuestionDao
) : QuestionRepository {
    override fun getQuesitons(): Flow<List<Question>> {
        return questionDao.getQuestionsWithOptions().map { list ->
            list.map { it.toModel() }
        }
    }

    override suspend fun addQuestion(title: String) {
        questionDao.insertQuestion(QuestionEntity(title = title))
    }

    override suspend fun deleteQuesiton(question: Question) {
        questionDao.deleteQuestion(question.toEntity())
    }
}