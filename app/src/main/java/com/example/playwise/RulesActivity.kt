package com.example.playwise

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import com.example.playwise.databinding.ActivityRulesBinding
import com.google.android.material.card.MaterialCardView

class RulesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRulesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRulesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sport = intent.getStringExtra("sport_name") ?: intent.getStringExtra("SPORT") ?: "Sport"

        binding.toolbar.title = "$sport Rules"
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupRulesCards(sport)
    }

    private fun setupRulesCards(sport: String) {
        val container = binding.rulesContainer
        container.removeAllViews()

        val rulesData = getRulesData(sport)
        
        rulesData.forEach { (title, content) ->
            val card = MaterialCardView(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 0, 0, 32) // Increased spacing between cards
                }
                radius = 24f // More rounded corners
                cardElevation = 8f // More pronounced shadow
                setCardBackgroundColor(Color.WHITE)
                setContentPadding(48, 48, 48, 48) // More internal padding
            }

            val cardContent = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
            }

            // Title
            val titleView = TextView(this).apply {
                text = title
                textSize = 22f
                setTypeface(null, Typeface.BOLD)
                setTextColor("#212121".toColorInt())
                setPadding(0, 0, 0, 24)
            }
            cardContent.addView(titleView)

            // Content
            val contentView = TextView(this).apply {
                text = content
                textSize = 16f
                setTextColor("#424242".toColorInt())
                setLineSpacing(12f, 1f) // Better readability
            }
            cardContent.addView(contentView)

            card.addView(cardContent)
            container.addView(card)
        }
    }

    private fun getRulesData(sport: String): List<Pair<String, String>> {
        return when (sport.lowercase()) {
            "cricket" -> listOf(
                "Objective" to "The batting team scores runs by hitting the ball with the bat and running between the wickets, while the bowling and fielding team tries to dismiss each batter. 1. Basic Information\n" +
                        "\n" +
                        "• Two teams compete against each other\n" +
                        "• Each team has 11 players\n" +
                        "• The match is played on a 22-yard pitch\n" +
                        "• The team scoring more runs wins\n" +
                        "\n" +
                        "2. Objective of the Game\n" +
                        "\n" +
                        "The main objective in cricket is to score more runs than the opposing team. One team bats to score runs, while the other team bowls and fields to prevent runs and dismiss the batsmen.\n" +
                        "\n" +
                        "3. Match Structure\n" +
                        "\n" +
                        "• The game is divided into innings\n" +
                        "• Each team gets a turn to bat and bowl\n" +
                        "• An over consists of 6 legal deliveries\n" +
                        "• The innings ends when 10 batsmen are out or overs are completed\n" +
                        "\n" +
                        "4. Scoring Runs\n" +
                        "\n" +
                        "• 1 Run – By running between the wickets\n" +
                        "• 4 Runs – Ball reaches boundary after bouncing\n" +
                        "• 6 Runs – Ball crosses boundary without bouncing\n" +
                        "• Extra runs – Awarded for no balls and wide balls\n" +
                        "\n" +
                        "5. Ways a Batsman Can Get Out\n" +
                        "\n" +
                        "• Bowled\n" +
                        "• Caught\n" +
                        "• Run Out\n" +
                        "• LBW (Leg Before Wicket)\n" +
                        "• Stumped\n" +
                        "\n" +
                        "6. Formats of Cricket\n" +
                        "\n" +
                        "• Test Match – Played up to 5 days\n" +
                        "• One Day International (ODI) – 50 overs per side\n" +
                        "• T20 Match – 20 overs per side\n" +
                        "\n" +
                        "Cricket is not just a game but a sport that promotes discipline, teamwork, and sportsmanship. It is one of the most popular sports in the world and is widely followed in many countries.",
                "Scoring" to "• 1-3 Runs: Running between wickets.\n• 4 Runs: Ball hits the ground and then crosses the boundary.\n• 6 Runs: Ball crosses the boundary without hitting the ground.",
                "Dismissals" to "Common ways to get out: Bowled, Caught, LBW (Leg Before Wicket), Run Out, and Stumped."
            )
            "football" -> listOf(
                "Objective" to "The object of the game is to score by maneuvering the ball into the opposing goal.",
                "Key Rules" to "• No Hands: Players cannot use their hands or arms (except the goalkeeper).\n• Match Duration: A standard match consists of two 45-minute halves.\n• Fouls: Physical contact like tripping or pushing results in a free kick or penalty."
            )
            "basketball" -> listOf(
                "Objective" to "The objective is to shoot a ball through a hoop that is 10 feet high.",
                "Scoring" to "• 2 Points: Field goal made from inside the three-point line.\n• 3 Points: Field goal made from outside the three-point line.\n• 1 Point: Free throw.",
                "Violations" to "Common violations include Traveling, Double Dribbling, and personal fouls."
            )
            "volleyball" -> listOf(
                "Objective" to "Each team tries to score points by grounding a ball on the opposing team's court under organized rules.",
                "Key Rules" to "• Three Hits: A team is allowed three hits to return the ball.\n• No Double Hit: A player cannot hit the ball twice in succession.\n• Rotation: Players rotate clockwise after winning a serve."
            )
            "hockey" -> listOf(
                "Objective" to "To score more goals than the opponent by hitting the ball into the opponent's goal.",
                "Key Rules" to "• Flat Side: Players must only use the flat side of their stick.\n• Feet: Players (except the goalie) cannot use their feet to play the ball.\n• Scoring: A goal is scored only if hit from within the \"shooting circle\"."
            )
            "tennis" -> listOf(
                "Objective" to "To hit the ball over the net and into the opponent's court in a way that they cannot return it.",
                "Scoring System" to "• Points: Love (0), 15, 30, 40, Game.\n• Deuce: A tie at 40-40, requiring a two-point lead to win.\n• Sets: A match is usually best of 3 or 5 sets."
            )
            "badminton" -> listOf(
                "Objective" to "To hit the shuttlecock over the net and land it within the opponent's court boundaries.",
                "Key Rules" to "• Service: The serve must be hit underarm and below the waist.\n• Let: A rally is replayed if an unexpected disturbance occurs.\n• Winning: Matches are usually best of three games to 21 points."
            )
            else -> listOf("Error" to "Rules for $sport are not available yet.")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
