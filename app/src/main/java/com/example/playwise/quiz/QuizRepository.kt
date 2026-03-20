package com.example.playwise.quiz

import kotlinx.coroutines.flow.Flow

class QuizRepository(private val quizDao: QuizDao) {

    val allResults: Flow<List<QuizResultEntity>> = quizDao.getAllResults()
    val highestScore: Flow<Int?> = quizDao.getHighestScore()

    suspend fun getRandomQuestions(limit: Int): List<QuestionEntity> {
        var questions = quizDao.getRandomUnusedQuestions(limit)
        if (questions.size < limit) {
            quizDao.resetUsedQuestions()
            questions = quizDao.getRandomUnusedQuestions(limit)
        }
        return questions
    }

    suspend fun updateQuestion(question: QuestionEntity) {
        quizDao.updateQuestion(question)
    }

    suspend fun insertResult(result: QuizResultEntity) {
        quizDao.insertResult(result)
    }
}
