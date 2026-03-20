package com.example.playwise.quiz

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao {
    @Query("SELECT * FROM questions WHERE isUsed = 0 ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomUnusedQuestions(limit: Int): List<QuestionEntity>

    @Query("UPDATE questions SET isUsed = 0")
    suspend fun resetUsedQuestions(): Int

    @Query("SELECT COUNT(*) FROM questions WHERE isUsed = 0")
    suspend fun getUnusedCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<QuestionEntity>): List<Long>

    @Update
    suspend fun updateQuestion(question: QuestionEntity): Int

    @Insert
    suspend fun insertResult(result: QuizResultEntity): Long

    @Query("SELECT * FROM quiz_results ORDER BY date DESC")
    fun getAllResults(): Flow<List<QuizResultEntity>>

    @Query("SELECT MAX(score) FROM quiz_results")
    fun getHighestScore(): Flow<Int?>
}
