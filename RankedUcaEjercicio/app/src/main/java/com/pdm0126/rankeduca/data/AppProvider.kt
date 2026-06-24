package com.pdm0126.rankeduca.data

import android.content.Context
import com.pdm0126.rankeduca.data.database.AppDatabase
import com.pdm0126.rankeduca.data.repository.OptionRepository.OptionRepository
import com.pdm0126.rankeduca.data.repository.OptionRepository.OptionRepositoryImpl
import com.pdm0126.rankeduca.data.repository.QuestionRepository.QuestionRepository
import com.pdm0126.rankeduca.data.repository.QuestionRepository.QuestionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val questionDao = appDatabase.questionDao()
    private val optionDao = appDatabase.optionDao()
    private val questionRepository: QuestionRepository =
        QuestionRepositoryImpl(questionDao)
    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideQuestionRepository(): QuestionRepository {
        return questionRepository
    }

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}