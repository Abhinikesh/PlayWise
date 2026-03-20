package com.example.playwise.quiz

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [QuestionEntity::class, QuizResultEntity::class], version = 1, exportSchema = false)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun quizDao(): QuizDao

    companion object {
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "quiz_database"
                )
                .addCallback(QuizDatabaseCallback(scope))
                .build()
                INSTANCE = instance
                instance
            }
        }

        private class QuizDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.quizDao())
                    }
                }
            }

            suspend fun populateDatabase(quizDao: QuizDao) {
                // Now using QuizSeeder for centralized question management
                val questions = QuizSeeder.getDefaultQuestions()
                quizDao.insertQuestions(questions)
            }
        }
    }
}
