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
                Ground(
                    "HPCA Stadium",
                    "📍 Dharamshala, India - 22 yard pitch\n🏟 Capacity: 20,000 seats\n🏏 Matches Played: 19",
                    R.drawable.dharamshala
                ),
                Ground(
                    "Lord's Cricket Ground",
                    "📍 London, UK - Home of Cricket\n🏟 Capacity: 30,000 seats\n🏏 Matches Played: 76",
                    R.drawable.lords_crc_grd
                ),
                Ground(
                    "MCG",
                    "📍 Melbourne, Australia\n🏟 Capacity: 100,024 seats\n🏏 Matches Played: 150+",
                    R.drawable.mcg
                ),
                Ground(
                    "Eden Gardens",
                    "📍 Kolkata, India - Historic Stadium\n🏟 Capacity: 66,000 seats\n🏏 Matches Played: 100+",
                    R.drawable.cricket
                ),
                Ground(
                    "Wankhede Stadium",
                    "📍 Mumbai, India - Sea-facing venue\n🏟 Capacity: 33,108 seats\n🏏 Matches Played: 80+",
                    R.drawable.cricket
                )
            )

            "football" -> listOf(
                Ground(
                    "Camp Nou",
                    "📍 Barcelona, Spain\n🏟 Capacity: 99,354 seats\n⚽ Matches Played: 500+",
                    R.drawable.football
                ),
                Ground(
                    "Old Trafford",
                    "📍 Manchester, UK - Theatre of Dreams\n🏟 Capacity: 74,310 seats\n⚽ Matches Played: 450+",
                    R.drawable.football
                ),
                Ground(
                    "Wembley Stadium",
                    "📍 London, UK\n🏟 Capacity: 90,000 seats\n⚽ Matches Played: 300+",
                    R.drawable.football
                ),
                Ground(
                    "Allianz Arena",
                    "📍 Munich, Germany\n🏟 Capacity: 75,024 seats\n⚽ Matches Played: 200+",
                    R.drawable.football
                ),
                Ground(
                    "Santiago Bernabeu",
                    "📍 Madrid, Spain\n🏟 Capacity: 81,044 seats\n⚽ Matches Played: 400+",
                    R.drawable.football
                )
            )

            "basketball" -> listOf(
                Ground(
                    "Madison Square Garden",
                    "📍 New York - Multi-purpose Arena\n🏟 Capacity: 19,812 seats\n🏀 Matches Played: 500+",
                    R.drawable.basketball
                ),
                Ground(
                    "Crypto.com Arena",
                    "📍 Los Angeles - Home of Lakers\n🏟 Capacity: 19,079 seats\n🏀 Matches Played: 450+",
                    R.drawable.basketball
                ),
                Ground(
                    "United Center",
                    "📍 Chicago - Home of Bulls\n🏟 Capacity: 20,917 seats\n🏀 Matches Played: 400+",
                    R.drawable.basketball
                ),
                Ground(
                    "Chase Center",
                    "📍 San Francisco - Warriors Arena\n🏟 Capacity: 18,064 seats\n🏀 Matches Played: 150+",
                    R.drawable.basketball
                ),
                Ground(
                    "TD Garden",
                    "📍 Boston - Celtics Arena\n🏟 Capacity: 19,156 seats\n🏀 Matches Played: 350+",
                    R.drawable.basketball
                )
            )

            "volleyball" -> listOf(
                Ground(
                    "Tokyo Metropolitan Gymnasium",
                    "📍 Tokyo, Japan - Olympic Venue\n🏟 Capacity: 10,000 seats\n🏐 Matches Played: 120+",
                    R.drawable.vollyball
                ),
                Ground(
                    "Earvin N'Gapeth Arena",
                    "📍 Poitiers, France\n🏟 Capacity: 5,000 seats\n🏐 Matches Played: 80+",
                    R.drawable.vollyball
                ),
                Ground(
                    "Maracanazinho",
                    "📍 Rio de Janeiro, Brazil\n🏟 Capacity: 11,800 seats\n🏐 Matches Played: 300+",
                    R.drawable.vollyball
                ),
                Ground(
                    "Forum Assago",
                    "📍 Milan, Italy\n🏟 Capacity: 12,700 seats\n🏐 Matches Played: 150+",
                    R.drawable.vollyball
                ),
                Ground(
                    "Spodek Arena",
                    "📍 Katowice, Poland\n🏟 Capacity: 11,036 seats\n🏐 Matches Played: 200+",
                    R.drawable.vollyball
                )
            )

            "hockey" -> listOf(
                Ground(
                    "Kalinga Stadium",
                    "📍 Bhubaneswar, India\n🏟 Capacity: 15,000 seats\n🏑 Matches Played: 250+",
                    R.drawable.hockey
                ),
                Ground(
                    "Wagener Stadium",
                    "📍 Amstelveen, Netherlands\n🏟 Capacity: 9,000 seats\n🏑 Matches Played: 400+",
                    R.drawable.hockey
                ),
                Ground(
                    "Lee Valley Hockey Centre",
                    "📍 London, UK\n🏟 Capacity: 3,000 seats\n🏑 Matches Played: 180+",
                    R.drawable.hockey
                ),
                Ground(
                    "Birsa Munda International Stadium",
                    "📍 Rourkela, India - World's Largest\n🏟 Capacity: 20,000 seats\n🏑 Matches Played: 60+",
                    R.drawable.hockey
                ),
                Ground(
                    "Sydney Olympic Park",
                    "📍 Sydney, Australia\n🏟 Capacity: 8,000 seats\n🏑 Matches Played: 220+",
                    R.drawable.hockey
                )
            )

            "tennis" -> listOf(
                Ground(
                    "Wimbledon",
                    "📍 London - Grass Court\n🏟 Capacity: 15,000 seats\n🎾 Matches Played: 120+",
                    R.drawable.tennis
                ),
                Ground(
                    "Roland Garros",
                    "📍 Paris - Clay Court\n🏟 Capacity: 15,000 seats\n🎾 Matches Played: 110+",
                    R.drawable.tennis
                ),
                Ground(
                    "Arthur Ashe Stadium",
                    "📍 New York - Hard Court\n🏟 Capacity: 23,771 seats\n🎾 Matches Played: 150+",
                    R.drawable.tennis
                ),
                Ground(
                    "Rod Laver Arena",
                    "📍 Melbourne - Hard Court\n🏟 Capacity: 14,820 seats\n🎾 Matches Played: 100+",
                    R.drawable.tennis
                ),
                Ground(
                    "Indian Wells",
                    "📍 California - Hard Court\n🏟 Capacity: 16,100 seats\n🎾 Matches Played: 90+",
                    R.drawable.tennis
                )
            )

            "badminton" -> listOf(
                Ground(
                    "Istora Senayan",
                    "📍 Jakarta - Indoor Court\n🏟 Capacity: 7,166 seats\n🏸 Matches Played: 200+",
                    R.drawable.badminton
                ),
                Ground(
                    "Musashino Forest Plaza",
                    "📍 Tokyo - Indoor Court\n🏟 Capacity: 10,000 seats\n🏸 Matches Played: 50+",
                    R.drawable.badminton
                ),
                Ground(
                    "Axiata Arena",
                    "📍 Kuala Lumpur - Indoor Court\n🏟 Capacity: 16,000 seats\n🏸 Matches Played: 150+",
                    R.drawable.badminton
                ),
                Ground(
                    "Binjiang Gymnasium",
                    "📍 Hangzhou - Indoor Court\n🏟 Capacity: 5,000 seats\n🏸 Matches Played: 40+",
                    R.drawable.badminton
                ),
                Ground(
                    "Barclaycard Arena",
                    "📍 Birmingham - Indoor Court\n🏟 Capacity: 15,800 seats\n🏸 Matches Played: 100+",
                    R.drawable.badminton
                )
            )

            "rugby" -> listOf(
                Ground(
                    "Twickenham Stadium",
                    "📍 London - Grass Pitch\n🏟 Capacity: 82,000 seats\n🏉 Matches Played: 300+",
                    R.drawable.rugby
                ),
                Ground(
                    "Stade de France",
                    "📍 Paris - Hybrid Grass\n🏟 Capacity: 80,698 seats\n🏉 Matches Played: 150+",
                    R.drawable.rugby
                ),
                Ground(
                    "Eden Park",
                    "📍 Auckland - Grass Pitch\n🏟 Capacity: 50,000 seats\n🏉 Matches Played: 400+",
                    R.drawable.rugby
                ),
                Ground(
                    "Ellis Park Stadium",
                    "📍 Johannesburg - Grass Pitch\n🏟 Capacity: 62,567 seats\n🏉 Matches Played: 200+",
                    R.drawable.rugby
                ),
                Ground(
                    "Murrayfield Stadium",
                    "📍 Edinburgh - Grass Pitch\n🏟 Capacity: 67,144 seats\n🏉 Matches Played: 250+",
                    R.drawable.rugby
                )
            )

            "golf" -> listOf(
                Ground(
                    "Augusta National Golf Club",
                    "📍 Georgia, USA - Home of the Masters\n🏟 Capacity: Varies\n⛳ Tournaments: 85+",
                    R.drawable.rugby
                ),
                Ground(
                    "St Andrews Links",
                    "📍 Fife, Scotland - The Home of Golf\n🏟 Capacity: Public Access\n⛳ Open Championships: 30",
                    R.drawable.rugby
                ),
                Ground(
                    "Pebble Beach Golf Links",
                    "📍 California, USA - Famous Coastal Course\n🏟 Capacity: 30,000+ (Gallery)\n⛳ US Opens: 6",
                    R.drawable.rugby
                )
            )

            "handball" -> listOf(
                Ground(
                    "Lanxess Arena",
                    "📍 Cologne, Germany\n🏟 Capacity: 19,750 seats\n🤾 Matches Played: 200+",
                    R.drawable.rugby
                ),
                Ground(
                    "Lusail Multipurpose Hall",
                    "📍 Lusail, Qatar\n🏟 Capacity: 15,300 seats\n🤾 Matches Played: 100+",
                    R.drawable.rugby
                ),
                Ground(
                    "Cairo Stadium Indoor Halls Complex",
                    "📍 Cairo, Egypt\n🏟 Capacity: 17,000 seats\n🤾 Matches Played: 150+",
                    R.drawable.rugby
                )
            )

            "boxing" -> listOf(
                Ground(
                    "Madison Square Garden",
                    "📍 New York, USA - Mecca of Boxing\n🏟 Capacity: 20,789 seats\n🥊 Historic Fights: 500+",
                    R.drawable.rugby
                ),
                Ground(
                    "MGM Grand Garden Arena",
                    "📍 Las Vegas, USA\n🏟 Capacity: 17,000 seats\n🥊 Historic Fights: 300+",
                    R.drawable.rugby
                ),
                Ground(
                    "Wembley Stadium",
                    "📍 London, UK - World Title Venue\n🏟 Capacity: 90,000 seats\n🥊 Big Fights: 50+",
                    R.drawable.rugby
                )
            )

            "karate" -> listOf(
                Ground(
                    "Nippon Budokan",
                    "📍 Tokyo, Japan - Martial Arts Temple\n🏟 Capacity: 14,471 seats\n🥋 Major Events: 100+",
                    R.drawable.rugby
                ),
                Ground(
                    "Palacio de Deportes de la Comunidad de Madrid",
                    "📍 Madrid, Spain\n🏟 Capacity: 15,000 seats\n🥋 World Championships: 5+",
                    R.drawable.rugby
                )
            )

            "wrestling" -> listOf(
                Ground(
                    "Ryogoku Kokugikan",
                    "📍 Tokyo, Japan\n🏟 Capacity: 11,091 seats\n🤼 Major Events: 200+",
                    R.drawable.rugby
                ),
                Ground(
                    "Papp László Budapest Sportaréna",
                    "📍 Budapest, Hungary\n🏟 Capacity: 12,500 seats\n🤼 World Championships: 10+",
                    R.drawable.rugby
                )
            )

            "formula 1" -> listOf(
                Ground(
                    "Circuit de Monaco",
                    "📍 Monte Carlo, Monaco - Street Circuit\n🏟 Capacity: 37,000 seats\n🏎 Grands Prix: 80+",
                    R.drawable.rugby
                ),
                Ground(
                    "Silverstone Circuit",
                    "📍 Northamptonshire, UK\n🏟 Capacity: 150,000 seats\n🏎 Grands Prix: 75+",
                    R.drawable.rugby
                ),
                Ground(
                    "Suzuka International Racing Course",
                    "📍 Suzuka, Japan\n🏟 Capacity: 155,000 seats\n🏎 Grands Prix: 33",
                    R.drawable.rugby
                )
            )

            "shooting" -> listOf(
                Ground(
                    "Asaka Shooting Range",
                    "📍 Tokyo, Japan\n🏟 Capacity: 3,000 seats\n🎯 Olympic Events: 20+",
                    R.drawable.rugby
                ),
                Ground(
                    "Royal Artillery Barracks",
                    "📍 London, UK\n🏟 Capacity: 7,500 seats\n🎯 Major Competitions: 15+",
                    R.drawable.rugby
                )
            )

            "kabaddi" -> listOf(
                Ground(
                    "Tau Devi Lal Stadium",
                    "📍 Panchkula, India\n🏟 Capacity: 7,000 seats\n🇮🇳 PKL Matches: 100+",
                    R.drawable.rugby
                ),
                Ground(
                    "Netaji Indoor Stadium",
                    "📍 Kolkata, India\n🏟 Capacity: 12,000 seats\n🇮🇳 PKL Matches: 80+",
                    R.drawable.rugby
                ),
                Ground(
                    "Sree Kanteerava Indoor Stadium",
                    "📍 Bengaluru, India\n🏟 Capacity: 4,000 seats\n🇮🇳 PKL Matches: 120+",
                    R.drawable.rugby
                )
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