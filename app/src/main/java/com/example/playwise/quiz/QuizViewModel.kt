package com.example.playwise.quiz

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuizViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: QuizRepository
    val allResults: LiveData<List<QuizResultEntity>>
    val highestScore: LiveData<Int?>

    private val _currentQuestions = MutableLiveData<List<QuestionEntity>>()
    val currentQuestions: LiveData<List<QuestionEntity>> = _currentQuestions

    private val _currentIndex = MutableLiveData(0)
    val currentIndex: LiveData<Int> = _currentIndex

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    private val _isQuizFinished = MutableLiveData(false)
    val isQuizFinished: LiveData<Boolean> = _isQuizFinished

    init {
        val quizDao = QuizDatabase.getDatabase(application, viewModelScope).quizDao()
        repository = QuizRepository(quizDao)
        allResults = repository.allResults.asLiveData()
        highestScore = repository.highestScore.asLiveData()
    }

    fun startNewQuiz() {
        viewModelScope.launch(Dispatchers.IO) {
            val questions = repository.getRandomQuestions(5)
            _currentQuestions.postValue(questions)
            _currentIndex.postValue(0)
            _score.postValue(0)
            _isQuizFinished.postValue(false)
        }
    }

    fun submitAnswer(selectedOption: Int) {
        val questions = _currentQuestions.value ?: return
        val index = _currentIndex.value ?: 0
        
        val currentQuestion = questions[index]
        if (selectedOption == currentQuestion.correctAnswer) {
            _score.value = (_score.value ?: 0) + 1
        }

        // Mark question as used
        viewModelScope.launch(Dispatchers.IO) {
            currentQuestion.isUsed = true
            repository.updateQuestion(currentQuestion)
        }

        if (index + 1 < questions.size) {
            _currentIndex.value = index + 1
        } else {
            finishQuiz()
        }
    }

    private fun finishQuiz() {
        val finalScore = _score.value ?: 0
        val total = _currentQuestions.value?.size ?: 5
        val percentage = (finalScore.toFloat() / total) * 100

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertResult(QuizResultEntity(score = finalScore, totalQuestions = total, percentage = percentage))
            _isQuizFinished.postValue(true)
        }
    }

    class Factory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return QuizViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
