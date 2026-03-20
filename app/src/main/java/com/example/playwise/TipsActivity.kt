package com.example.playwise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.playwise.databinding.ActivityTipsBinding

class TipsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sport = intent.getStringExtra("sport_name") ?: "Sport"
        binding.toolbar.title = "$sport - Tips"

        val tipsText = when (sport.lowercase()) {
            "cricket" -> """
                Batting Tips:
                • Keep eyes on the ball.
                • Play with soft hands for shots along the ground.
                • Footwork: move forward or back early.
                
                Bowling Tips:
                • Run-up rhythm and consistent release point.
                • Target areas, vary pace.
                
                Fielding Tips:
                • Stay low, quick hands, watch the ball into gloves.
            """.trimIndent()

            "football" -> """
                Attacking:
                • Keep close control, use both feet.
                • Look up before receiving the ball.
                
                Defending:
                • Stay on your feet, jockey the attacker.
                • Communication is key.
            """.trimIndent()

            "basketball" -> """
                Shooting:
                • Use legs, follow-through with wrist.
                • Square shoulders to the basket.
                
                Defense:
                • Stay on the balls of your feet.
                • Hands active to contest shots and passes.
            """.trimIndent()

            "volleyball" -> """
                Serving:
                • Use consistent toss, step and swing rhythm.
                
                Passing:
                • Platform steady, angle toward setter.
                
                Hitting:
                • Approach rhythm, swing high and hit with the wrist snap.
            """.trimIndent()

            "hockey" -> """
                Serving:
                • Use consistent toss, step and swing rhythm.
                
                Passing:
                • Platform steady, angle toward setter.
                
                Hitting:
                • Approach rhythm, swing high and hit with the wrist snap.
            """.trimIndent()

            "tennis" -> """
                Serving:
                • Use consistent toss, step and swing rhythm.
                
                Passing:
                • Platform steady, angle toward setter.
                
                Hitting:
                • Approach rhythm, swing high and hit with the wrist snap.
            """.trimIndent()

            "badminton" -> """
                Serving:
                • Use consistent toss, step and swing rhythm.
                
                Passing:
                • Platform steady, angle toward setter.
                
                Hitting:
                • Approach rhythm, swing high and hit with the wrist snap.
            """.trimIndent()

            "rugby" -> """
                Serving:
                • Use consistent toss, step and swing rhythm.
                
                Passing:
                • Platform steady, angle toward setter.
                
                Hitting:
                • Approach rhythm, swing high and hit with the wrist snap.
            """.trimIndent()

            else -> "Tips not available."
        }

        binding.txtTips.text = tipsText
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}