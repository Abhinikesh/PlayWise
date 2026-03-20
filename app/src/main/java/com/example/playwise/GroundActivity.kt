package com.example.playwise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playwise.databinding.ActivityGroundBinding

class GroundActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGroundBinding

    // Data class
    data class Ground(
        val name: String,
        val details: String,
        val image: Int
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sport = intent.getStringExtra("sport_name") ?: "Sport"
        binding.toolbar.title = "$sport - Grounds"

        // Create 5 grounds for each sport
        val grounds = when (sport.lowercase()) {

            "cricket" -> listOf(
                Ground("HPCA Stadium", "Dharamshala - 22 yard pitch", R.drawable.dharamshala),
                Ground("Lord's Cricket Ground", "London - Home of Cricket", R.drawable.cricket),
                Ground("MCG", "Melbourne - 100,000+ capacity", R.drawable.cricket),
                Ground("Eden Gardens", "Kolkata - Historic stadium", R.drawable.cricket),
                Ground("Wankhede Stadium", "Mumbai - Sea facing stadium", R.drawable.cricket)
            )

            "football" -> listOf(
                Ground("Camp Nou", "Barcelona - 99,000 capacity", R.drawable.football),
                Ground("Old Trafford", "Manchester - 74,000 capacity", R.drawable.football),
                Ground("Wembley Stadium", "London - 90,000 capacity", R.drawable.football),
                Ground("Allianz Arena", "Germany - 75,000 capacity", R.drawable.football),
                Ground("Santiago Bernabeu", "Madrid - Real Madrid stadium", R.drawable.football)
            )

            "basketball" -> listOf(
                Ground("Madison Square Garden", "New York", R.drawable.basketball),
                Ground("Staples Center", "Los Angeles", R.drawable.basketball),
                Ground("United Center", "Chicago", R.drawable.basketball),
                Ground("Chase Center", "San Francisco", R.drawable.basketball),
                Ground("TD Garden", "Boston", R.drawable.basketball)
            )

            "volleyball" -> listOf(
                Ground("Tokyo Metropolitan Gymnasium", "Japan", R.drawable.vollyball),
                Ground("Earvin N'Gapeth Arena", "France", R.drawable.vollyball),
                Ground("Maracanazinho", "Brazil", R.drawable.vollyball),
                Ground("Forum Assago", "Italy", R.drawable.vollyball),
                Ground("Spodek Arena", "Poland", R.drawable.vollyball)
            )

            "hockey" -> listOf(
                Ground("Kalinga Stadium", "Bhubaneswar", R.drawable.hockey),
                Ground("Wagener Stadium", "Netherlands", R.drawable.hockey),
                Ground("Lee Valley Hockey Centre", "London", R.drawable.hockey),
                Ground("National Hockey Stadium", "India", R.drawable.hockey),
                Ground("Sydney Olympic Park", "Australia", R.drawable.hockey)
            )

            "tennis" -> listOf(
                Ground("Kalinga Stadium", "Bhubaneswar", R.drawable.hockey),
                Ground("Wagener Stadium", "Netherlands", R.drawable.hockey),
                Ground("Lee Valley Hockey Centre", "London", R.drawable.hockey),
                Ground("National Hockey Stadium", "India", R.drawable.hockey),
                Ground("Sydney Olympic Park", "Australia", R.drawable.hockey)
            )

            "badminton" -> listOf(
                Ground("Kalinga Stadium", "Bhubaneswar", R.drawable.hockey),
                Ground("Wagener Stadium", "Netherlands", R.drawable.hockey),
                Ground("Lee Valley Hockey Centre", "London", R.drawable.hockey),
                Ground("National Hockey Stadium", "India", R.drawable.hockey),
                Ground("Sydney Olympic Park", "Australia", R.drawable.hockey)
            )

            "rugby" -> listOf(
                Ground("Kalinga Stadium", "Bhubaneswar", R.drawable.hockey),
                Ground("Wagener Stadium", "Netherlands", R.drawable.hockey),
                Ground("Lee Valley Hockey Centre", "London", R.drawable.hockey),
                Ground("National Hockey Stadium", "India", R.drawable.hockey),
                Ground("Sydney Olympic Park", "Australia", R.drawable.hockey)
            )


            else -> listOf(
                Ground("No Data", "Ground details not available.", android.R.drawable.ic_menu_gallery)
            )
        }

        // Setup RecyclerView
        val adapter = GroundAdapter(grounds)
        binding.recyclerGrounds.layoutManager = LinearLayoutManager(this)
        binding.recyclerGrounds.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}