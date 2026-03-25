package com.example.playwise.quiz

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.playwise.FavoritesActivity
import com.example.playwise.MainActivity
import com.example.playwise.R
import com.example.playwise.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private val viewModel: QuizViewModel by viewModels {
        QuizViewModel.Factory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupBackgroundAnimation()
        observeViewModel()
        setupBottomNavigation()

        if (savedInstanceState == null) {
            viewModel.startNewQuiz()
        }

        binding.btnNext.setOnClickListener {
            val selectedId = binding.rgOptions.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedOption = when (selectedId) {
                R.id.rbOption1 -> 1
                R.id.rbOption2 -> 2
                R.id.rbOption3 -> 3
                R.id.rbOption4 -> 4
                else -> 1
            }

            viewModel.submitAnswer(selectedOption)
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false) // Use XML title
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.selectedItemId = R.id.nav_quiz
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    true
                }
                R.id.nav_search -> {
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    // MainActivity can handle expanding search if we pass an extra or use a specific action
                    true
                }
                R.id.nav_live -> {
                    val url = "https://www.google.com/search?q=live+sports+score"
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    false
                }
                R.id.nav_favorites -> {
                    startActivity(Intent(this, FavoritesActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    true
                }
                R.id.nav_quiz -> true
                else -> false
            }
        }
    }

    private fun setupBackgroundAnimation() {
        val colorFrom = ContextCompat.getColor(this, R.color.quiz_bg_start)
        val colorTo = ContextCompat.getColor(this, R.color.quiz_bg_end)

        ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo).apply {
            duration = 3000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            addUpdateListener { animator ->
                binding.quizRoot.setBackgroundColor(animator.animatedValue as Int)
            }
            start()
        }
    }

    private fun observeViewModel() {
        viewModel.currentQuestions.observe(this) { questions ->
            if (questions != null && questions.isNotEmpty()) {
                updateUI()
            }
        }

        viewModel.currentIndex.observe(this) { _ ->
            updateUI()
        }

        viewModel.isQuizFinished.observe(this) { finished ->
            if (finished) {
                showResultDialog()
            }
        }
    }

    private fun updateUI() {
        val questions = viewModel.currentQuestions.value ?: return
        val index = viewModel.currentIndex.value ?: 0
        
        if (index >= questions.size) return

        val currentQuestion = questions[index]
        
        binding.tvProgress.text = "Question ${index + 1}/${questions.size}"
        binding.tvQuestion.text = currentQuestion.question
        binding.rbOption1.text = currentQuestion.option1
        binding.rbOption2.text = currentQuestion.option2
        binding.rbOption3.text = currentQuestion.option3
        binding.rbOption4.text = currentQuestion.option4
        
        binding.rgOptions.clearCheck()
        
        binding.questionCard.alpha = 0f
        binding.questionCard.animate().alpha(1f).setDuration(500).start()
    }

    private fun showResultDialog() {
        val score = viewModel.score.value ?: 0
        val total = viewModel.currentQuestions.value?.size ?: 5
        val percentage = (score.toFloat() / total) * 100

        val message = when {
            percentage >= 80 -> "Excellent! You're a Sports Pro!"
            percentage >= 60 -> "Great job! You know your sports."
            else -> "Good effort! Keep learning."
        }

        AlertDialog.Builder(this)
            .setTitle("Quiz Result")
            .setMessage("Score: $score/$total\nPercentage: ${percentage.toInt()}%\n\n$message")
            .setCancelable(false)
            .setPositiveButton("Restart") { _, _ ->
                viewModel.startNewQuiz()
            }
            .setNegativeButton("Finish") { _, _ ->
                finish()
            }
            .show()
    }
}