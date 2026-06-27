package com.example.playwise

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playwise.databinding.ActivityTicketBinding
import com.example.playwise.quiz.QuizActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        setupBottomNavigation()
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavigation.selectedItemId = R.id.nav_tickets
        binding.bottomNavigation.post {
            animateBottomNavigationItem(binding.bottomNavigation, R.id.nav_tickets)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    false
                }
                R.id.nav_search -> {
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                        putExtra("open_search", true)
                    })
                    false
                }
                R.id.nav_live -> {
                    val url = "https://www.google.com/search?q=live+sports+score"
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    false
                }
                R.id.nav_tickets -> {
                    animateBottomNavigationItem(binding.bottomNavigation, item.itemId)
                    true
                }
                R.id.nav_favorites -> {
                    startActivity(Intent(this, FavoritesActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    false
                }
                R.id.nav_quiz -> {
                    startActivity(Intent(this, QuizActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    false
                }
                else -> false
            }
        }
    }

    private fun animateBottomNavigationItem(bottomNav: BottomNavigationView, itemId: Int) {
        val menu = bottomNav.menu
        for (i in 0 until menu.size()) {
            val id = menu.getItem(i).itemId
            val itemView = bottomNav.findViewById<View>(id) ?: continue
            
            val iconView = itemView.findViewById<View>(com.google.android.material.R.id.navigation_bar_item_icon_view)
            
            if (id == itemId) {
                iconView?.animate()
                    ?.scaleX(1.2f)
                    ?.scaleY(1.2f)
                    ?.alpha(1.0f)
                    ?.setDuration(200)
                    ?.setInterpolator(AccelerateDecelerateInterpolator())
                    ?.start()
            } else {
                iconView?.animate()
                    ?.scaleX(1.0f)
                    ?.scaleY(1.0f)
                    ?.alpha(0.8f)
                    ?.setDuration(200)
                    ?.setInterpolator(AccelerateDecelerateInterpolator())
                    ?.start()
            }
        }
    }

    private fun getFutureDate(daysAhead: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, daysAhead)
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(calendar.time)
    }

    private fun setupTrendingMatches() {
        val trendingMatches = listOf(
            Match("India vs Australia", "Cricket", "${getFutureDate(5)} | 9:00 AM", "Wankhede Stadium", "india+vs+australia"),
            Match("Man City vs Arsenal", "Football", "${getFutureDate(7)} | 9:00 PM", "Etihad Stadium", "man+city+vs+arsenal"),
            Match("Lakers vs Warriors", "Basketball", "${getFutureDate(12)} | 8:00 AM", "Chase Center", "lakers+vs+warriors"),
            Match("Masters Tournament", "Golf", "${getFutureDate(15)} | 10:00 AM", "Augusta National", "masters+tournament"),
            Match("Champions League Final", "Handball", "${getFutureDate(20)} | 6:00 PM", "Lanxess Arena", "handball+champions+league"),
            Match("Fury vs Usyk II", "Boxing", "${getFutureDate(45)} | 11:00 PM", "Kingdom Arena", "fury+vs+usyk"),
            Match("World Championships", "Karate", "${getFutureDate(60)} | 9:00 AM", "Nippon Budokan", "karate+world+championships"),
            Match("WrestleMania 42", "Wrestling", "${getFutureDate(90)} | 7:00 PM", "SoFi Stadium", "wrestlemania"),
            Match("Monaco Grand Prix", "Formula 1", "${getFutureDate(40)} | 3:00 PM", "Circuit de Monaco", "monaco+grand+prix"),
            Match("ISSF World Cup", "Shooting", "${getFutureDate(25)} | 8:00 AM", "New Delhi", "issf+world+cup"),
            Match("PKL Final", "Kabaddi", "${getFutureDate(10)} | 8:30 PM", "Tau Devi Lal Stadium", "pro+kabaddi+league")
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
            TicketItem("Rugby World Cup", R.drawable.rugby_n, "league", "rugby+world+cup"),
            TicketItem("PGA Tour", R.drawable.rugby_n, "league", "pga+tour"),
            TicketItem("EHF Euro", R.drawable.rugby_n, "league", "ehf+euro"),
            TicketItem("WBC", R.drawable.rugby_n, "league", "wbc+boxing"),
            TicketItem("WKF Premier League", R.drawable.rugby_n, "league", "wkf+karate"),
            TicketItem("WWE", R.drawable.rugby_n, "league", "wwe"),
            TicketItem("Formula 1", R.drawable.rugby_n, "league", "f1+championship"),
            TicketItem("ISSF", R.drawable.rugby_n, "league", "issf"),
            TicketItem("Pro Kabaddi", R.drawable.rugby_n, "league", "pro+kabaddi")
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
            Stadium("Eden Gardens", "Kolkata"),
            Stadium("Old Course St Andrews", "Scotland"),
            Stadium("SAP Garden", "Munich"),
            Stadium("Madison Square Garden", "New York"),
            Stadium("Budokan", "Tokyo"),
            Stadium("Saitama Super Arena", "Saitama"),
            Stadium("Silverstone Circuit", "Northamptonshire"),
            Stadium("Dr. Karni Singh Range", "New Delhi"),
            Stadium("Gachibowli Indoor Stadium", "Hyderabad")
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
            Match("Real Madrid vs Barcelona", "Football", getFutureDate(15), "Santiago Bernabéu", "el+clasico"),
            Match("Ind vs Eng Test", "Cricket", getFutureDate(30), "Hyderabad", "india+vs+england+test"),
            Match("Wimbledon Finals", "Tennis", getFutureDate(60), "London", "wimbledon+finals"),
            Match("The Open Championship", "Golf", getFutureDate(45), "Royal Troon", "the+open+championship"),
            Match("Handball Bundesliga", "Handball", getFutureDate(12), "Berlin", "handball+bundesliga"),
            Match("World Heavyweight Title", "Boxing", getFutureDate(75), "Las Vegas", "boxing+heavyweight+tickets"),
            Match("Karate 1 Premier League", "Karate", getFutureDate(22), "Cairo", "karate+1+premier+league"),
            Match("Royal Rumble", "Wrestling", getFutureDate(110), "Miami", "royal+rumble+tickets"),
            Match("British Grand Prix", "Formula 1", getFutureDate(55), "Silverstone", "british+grand+prix"),
            Match("Olympic Qualifiers", "Shooting", getFutureDate(35), "Munich", "shooting+olympic+qualifiers"),
            Match("World Kabaddi Cup", "Kabaddi", getFutureDate(18), "Amritsar", "world+kabaddi+cup")
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
        binding.ticketGolf.setOnClickListener { openTicketUrl("golf") }
        binding.ticketHandball.setOnClickListener { openTicketUrl("handball") }
        binding.ticketBoxing.setOnClickListener { openTicketUrl("boxing") }
        binding.ticketKarate.setOnClickListener { openTicketUrl("karate") }
        binding.ticketWrestling.setOnClickListener { openTicketUrl("wrestling") }
        binding.ticketFormula1.setOnClickListener { openTicketUrl("formula 1") }
        binding.ticketShooting.setOnClickListener { openTicketUrl("shooting") }
        binding.ticketKabaddi.setOnClickListener { openTicketUrl("kabaddi") }
    }

    private fun openTicketUrl(query: String) {
        val url = "https://www.google.com/search?q=${query}+match+tickets"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
