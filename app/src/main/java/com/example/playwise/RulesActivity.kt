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
                "Objective" to "1. Basic Information\n\n" +
                        "• Two teams with 11 players each\n" +
                        "• Match duration: 90 minutes (2 halves of 45 mins)\n" +
                        "• Played on a rectangular field with goals\n\n" +

                        "2. Objective of the Game\n\n" +
                        "To score goals by getting the ball into the opponent’s net.\n\n" +

                        "3. Key Rules\n\n" +
                        "• Players cannot use hands (except goalkeeper)\n" +
                        "• Offside rule applies\n" +
                        "• Game starts with kickoff\n\n" +

                        "4. Scoring\n\n" +
                        "• Each goal = 1 point\n\n" +

                        "5. Fouls & Penalties\n\n" +
                        "• Tripping, pushing → Free kick\n" +
                        "• Serious foul → Yellow/Red card\n" +
                        "• Penalty kick for fouls inside box\n\n" +

                        "Football builds teamwork and stamina."
            )
            "basketball" -> listOf(
                "Objective" to "1. Basic Information\n\n" +
                        "• Two teams with 5 players each\n" +
                        "• Played on a rectangular court\n" +
                        "• Game divided into 4 quarters\n\n" +

                        "2. Objective of the Game\n\n" +
                        "Score points by shooting the ball through the opponent’s hoop.\n\n" +

                        "3. Scoring\n\n" +
                        "• 2 points: Inside arc\n" +
                        "• 3 points: Outside arc\n" +
                        "• 1 point: Free throw\n\n" +

                        "4. Key Rules\n\n" +
                        "• Must dribble while moving\n" +
                        "• 24-second shot clock\n\n" +

                        "5. Violations\n\n" +
                        "• Traveling\n" +
                        "• Double dribble\n" +
                        "• Personal fouls\n\n" +

                        "Basketball improves agility and coordination."
            )
            "volleyball" -> listOf(
                "Objective" to "1. Basic Information\n\n" +
                        "• Two teams of 6 players each\n" +
                        "• Played on a rectangular court divided by a net\n" +
                        "• Matches are played in sets\n\n" +

                        "2. Objective of the Game\n\n" +
                        "The objective is to score points by sending the ball over the net and grounding it on the opponent’s court.\n\n" +

                        "3. Match Structure\n\n" +
                        "• Matches are best of 5 sets\n" +
                        "• Each set is played to 25 points (win by 2)\n" +
                        "• Final set (5th) is played to 15 points\n\n" +

                        "4. Gameplay Rules\n\n" +
                        "• Each team can hit the ball up to 3 times\n" +
                        "• A player cannot hit the ball twice consecutively\n" +
                        "• A block does not count as a hit\n\n" +

                        "5. Scoring System\n\n" +
                        "• Rally scoring is used (point on every serve)\n" +
                        "• Point scored when opponent fails to return ball\n\n" +

                        "6. Rotation\n\n" +
                        "• Players rotate clockwise after winning serve\n" +
                        "• Ensures all players serve\n\n" +

                        "7. Faults\n\n" +
                        "• Double hit\n" +
                        "• Carrying or lifting the ball\n" +
                        "• Touching the net\n" +
                        "• Foot fault during serve\n\n" +

                        "8. Player Positions\n\n" +
                        "• Front row: Attack and block\n" +
                        "• Back row: Defense and serve\n\n" +

                        "Volleyball develops teamwork, reflexes, and coordination."
            )
            "hockey" -> listOf(
                "Objective" to "1. Basic Information\n\n" +
                        "• Two teams with 11 players each\n" +
                        "• Played on a synthetic turf field\n" +
                        "• Match duration: 60 minutes (4 quarters)\n\n" +

                        "2. Objective of the Game\n\n" +
                        "To score goals by hitting the ball into the opponent’s goal using a hockey stick.\n\n" +

                        "3. Match Structure\n\n" +
                        "• 4 quarters of 15 minutes each\n" +
                        "• Short breaks between quarters\n\n" +

                        "4. Gameplay Rules\n\n" +
                        "• Only flat side of stick is allowed\n" +
                        "• Players cannot use feet or body (except goalkeeper)\n" +
                        "• No dangerous or high stick play\n\n" +

                        "5. Scoring\n\n" +
                        "• Goal is valid only if shot is taken inside shooting circle\n\n" +

                        "6. Fouls & Penalties\n\n" +
                        "• Minor fouls → Free hit\n" +
                        "• Serious fouls → Penalty corner or stroke\n" +
                        "• Dangerous play is penalized\n\n" +

                        "7. Key Positions\n\n" +
                        "• Forwards: Score goals\n" +
                        "• Midfielders: Control game\n" +
                        "• Defenders: Stop attacks\n" +
                        "• Goalkeeper: Protect goal\n\n" +

                        "8. Important Skills\n\n" +
                        "• Dribbling\n" +
                        "• Passing\n" +
                        "• Tackling\n\n" +

                        "Hockey improves speed, stamina, and teamwork."
            )
            "tennis" -> listOf(
                "Objective" to "1. Basic Information\n\n" +
                        "• Played between 2 (singles) or 4 players (doubles)\n" +
                        "• Played on different surfaces like grass, clay, or hard court\n" +
                        "• The player/team winning more sets wins the match\n\n" +

                        "2. Objective of the Game\n\n" +
                        "Players aim to hit the ball over the net into the opponent’s court in such a way that the opponent cannot return it.\n\n" +

                        "3. Match Structure\n\n" +
                        "• A match consists of sets\n" +
                        "• A set consists of games\n" +
                        "• Usually played as best of 3 or 5 sets\n\n" +

                        "4. Scoring System\n\n" +
                        "• Points: Love (0), 15, 30, 40, Game\n" +
                        "• Deuce occurs at 40-40\n" +
                        "• Player must win 2 consecutive points after deuce\n\n" +

                        "5. Key Rules\n\n" +
                        "• Serve must land diagonally in service box\n" +
                        "• Each player gets 2 serves\n" +
                        "• Ball can bounce only once before return\n\n" +

                        "6. Faults\n\n" +
                        "• Double fault (missing both serves)\n" +
                        "• Ball hitting net or going out\n\n" +

                        "Tennis improves fitness, focus, and coordination."
            )
            "badminton" -> listOf(
                "Objective" to "1. Basic Information\n\n" +
                        "• Played as singles or doubles\n" +
                        "• Played on a rectangular indoor court\n" +
                        "• Uses a shuttlecock instead of a ball\n\n" +

                        "2. Objective of the Game\n\n" +
                        "To hit the shuttlecock over the net and land it in the opponent’s court.\n\n" +

                        "3. Match Structure\n\n" +
                        "• Matches are best of 3 games\n" +
                        "• Each game is played to 21 points\n" +
                        "• Must win by 2 points\n\n" +

                        "4. Scoring System\n\n" +
                        "• Rally scoring (point on every rally)\n" +
                        "• Point awarded when opponent fails to return shuttle\n\n" +

                        "5. Service Rules\n\n" +
                        "• Serve must be underarm\n" +
                        "• Shuttle must be hit below waist\n" +
                        "• Serve diagonally into opponent’s court\n\n" +

                        "6. Gameplay Rules\n\n" +
                        "• Shuttle cannot hit the ground during rally\n" +
                        "• Players must stay within boundaries\n\n" +

                        "7. Faults\n\n" +
                        "• Shuttle out of bounds\n" +
                        "• Double hit\n" +
                        "• Touching the net\n\n" +

                        "8. Types of Shots\n\n" +
                        "• Smash (powerful shot)\n" +
                        "• Drop shot (soft near net)\n" +
                        "• Clear (deep shot)\n\n" +

                        "Badminton improves speed, reflexes, and agility."
            )
            "rugby" -> listOf(
                "Objective" to "1. Basic Information\n\n" +
                        "• Two teams with 15 players each (Rugby Union)\n" +
                        "• Played on a large rectangular field\n" +
                        "• Match duration: 80 minutes (2 halves of 40 mins)\n\n" +

                        "2. Objective of the Game\n\n" +
                        "The objective is to score more points than the opponent by carrying, passing, or kicking the ball into the opponent’s goal area.\n\n" +

                        "3. Match Structure\n\n" +
                        "• Two halves of 40 minutes each\n" +
                        "• Short halftime break\n" +
                        "• Game starts with a kickoff\n\n" +

                        "4. Scoring System\n\n" +
                        "• Try (5 points): Touching the ball in opponent’s goal area\n" +
                        "• Conversion (2 points): Kick after try\n" +
                        "• Penalty Kick (3 points)\n" +
                        "• Drop Goal (3 points)\n\n" +

                        "5. Gameplay Rules\n\n" +
                        "• Ball can be carried forward but passed backward only\n" +
                        "• Players can kick the ball forward\n" +
                        "• Tackling is allowed to stop opponent\n\n" +

                        "6. Set Pieces\n\n" +
                        "• Scrum: Restart play after minor infringement\n" +
                        "• Line-out: Restart when ball goes out of bounds\n\n" +

                        "7. Fouls & Penalties\n\n" +
                        "• Forward pass is not allowed\n" +
                        "• High tackle or dangerous play is penalized\n" +
                        "• Offside results in penalty\n\n" +

                        "8. Player Positions\n\n" +
                        "• Forwards: Strength and physical play\n" +
                        "• Backs: Speed and scoring\n\n" +

                        "Rugby builds strength, teamwork, and endurance."
            )
            else -> listOf("Error" to "Rules for $sport are not available yet.")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
