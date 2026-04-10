package com.example.playwise

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playwise.databinding.ActivityTicketBinding

class TicketActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { finish() }

        setupTrendingMatches()
        setupLeaguesRecyclerView()
        setupNearbyStadiums()
        setupUpcomingMatches()
        setupSportsGrid()
    }

    private fun setupTrendingMatches() {
        val trendingMatches = listOf(
            Match("India vs Australia", "Cricket", "Jan 24, 2027 | 9:00 AM", "Wankhede Stadium", "india+vs+australia"),
            Match("Man City vs Arsenal", "Football", "Oct 28, 2026 | 9:00 PM", "Etihad Stadium", "man+city+vs+arsenal"),
            Match("Lakers vs Warriors", "Basketball", "Nov 02, 2026 | 8:00 AM", "Chase Center", "lakers+vs+warriors")
        )

        val adapter = TrendingMatchAdapter(trendingMatches) { match ->
            openTicketUrl(match.url)
        }
        binding.recyclerTrending.adapter = adapter
    }

    private fun setupLeaguesRecyclerView() {
        val leagues = listOf(
            TicketItem("IPL", R.drawable.cricket_n, "league", "ipl"),
            TicketItem("ISL", R.drawable.football_n, "league", "isl"),
            TicketItem("Premier League", R.drawable.football_n, "league", "premier+league"),
            TicketItem("NBA", R.drawable.basket_ball_n, "league", "nba"),
            TicketItem("Rugby World Cup", R.drawable.rugby_n, "league", "rugby+world+cup")
        )

        val adapter = LeagueAdapter(leagues) { item ->
            openTicketUrl(item.sportKey)
        }
        binding.recyclerLeagues.adapter = adapter
    }

    private fun setupNearbyStadiums() {
        val stadiums = listOf(
            Stadium("Wankhede Stadium", "Mumbai"),
            Stadium("DY Patil Stadium", "Navi Mumbai"),
            Stadium("Jawaharlal Nehru Stadium", "Delhi"),
            Stadium("Eden Gardens", "Kolkata")
        )

        val adapter = NearbyStadiumAdapter(stadiums) { stadium ->
            val query = "tickets near ${stadium.name} ${stadium.city}"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$query"))
            startActivity(intent)
        }
        binding.recyclerNearby.adapter = adapter
    }

    private fun setupUpcomingMatches() {
        val upcomingMatches = listOf(
            Match("Real Madrid vs Barcelona", "Football", "Dec 10, 2026", "Santiago Bernabéu", "el+clasico"),
            Match("Ind vs Eng Test", "Cricket", "July 1, 2026", "Hyderabad", "india+vs+england+test"),
            Match("Wimbledon Finals", "Tennis", "July 14, 2026", "London", "wimbledon+finals")
        )

        val adapter = UpcomingMatchAdapter(upcomingMatches) { match ->
            addToCalendar(match)
        }
        binding.recyclerUpcoming.adapter = adapter
    }

    private fun addToCalendar(match: Match) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, match.title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, match.location)
            putExtra(CalendarContract.Events.DESCRIPTION, "Booked via PlayWise App")
            putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
        }
        startActivity(intent)
    }

    private fun setupSportsGrid() {
        binding.ticketCricket.setOnClickListener { openTicketUrl("cricket") }
        binding.ticketFootball.setOnClickListener { openTicketUrl("football") }
        binding.ticketBasketball.setOnClickListener { openTicketUrl("basketball") }
        binding.ticketVolleyball.setOnClickListener { openTicketUrl("volleyball") }
        binding.ticketHockey.setOnClickListener { openTicketUrl("hockey") }
        binding.ticketTennis.setOnClickListener { openTicketUrl("tennis") }
        binding.ticketBadminton.setOnClickListener { openTicketUrl("badminton") }
        binding.ticketRugby.setOnClickListener { openTicketUrl("rugby") }
    }

    private fun openTicketUrl(query: String) {
        val url = "https://www.google.com/search?q=${query}+match+tickets"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
