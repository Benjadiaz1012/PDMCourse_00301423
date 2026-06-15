package com.pdm0126.rankeduca.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.pdm0126.rankeduca.data.database.entities.QuestionEntity
import com.pdm0126.rankeduca.data.database.entities.QuestionWithOptions
import com.pdm0126.rankeduca.data.model.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {
    @Transaction
    @Query("SELECT * FROM questions")
    fun getQuestionsWithOptions(): Flow<List<QuestionWithOptions>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionEntity)

    @Delete
    suspend fun deleteQuestion(question: QuestionEntity)
}