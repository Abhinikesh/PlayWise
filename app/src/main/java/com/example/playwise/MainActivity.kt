package com.example.playwise

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.playwise.databinding.ActivityMainBinding
import androidx.appcompat.widget.SearchView
import com.example.playwise.quiz.QuizActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: SharedPreferences
    private lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val night = prefs.getBoolean("night_mode", false)
        AppCompatDelegate.setDefaultNightMode(if (night) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setupClickListeners()
        setupBottomNavigation()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        networkMonitor = NetworkMonitor(this)
    }

    override fun onResume() {
        super.onResume()
        updateFavoriteIcons()
    }

    override fun onStart() {
        super.onStart()
        networkMonitor.start { isOnline ->
            runOnUiThread {
                binding.offlineIndicator.visibility = if (isOnline) View.GONE else View.VISIBLE
            }
        }
    }

    override fun onStop() {
        super.onStop()
        networkMonitor.stop()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.selectedItemId = R.id.nav_home
        
        binding.bottomNavigation.post {
            animateBottomNavigationItem(binding.bottomNavigation, R.id.nav_home)
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            animateBottomNavigationItem(binding.bottomNavigation, item.itemId)
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_search -> {
                    binding.toolbar.menu.findItem(R.id.action_search)?.expandActionView()
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
                    false
                }
                R.id.nav_quiz -> {
                    startActivity(Intent(this, QuizActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                    })
                    true
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

    private fun setupClickListeners() {
        binding.cardCricket.setOnClickListener { openSport("Cricket") }
        binding.cardFootball.setOnClickListener { openSport("Football") }
        binding.cardBasketball.setOnClickListener { openSport("Basketball") }
        binding.cardVolleyball.setOnClickListener { openSport("Volleyball") }
        binding.cardHockey.setOnClickListener { openSport("Hockey") }
        binding.cardTennis.setOnClickListener { openSport("Tennis") }
        binding.cardBadminton.setOnClickListener { openSport("Badminton") }
        binding.cardRugby.setOnClickListener { openSport("Rugby") }

        binding.btnFavCricket.setOnClickListener { toggleFavorite("Cricket", binding.btnFavCricket) }
        binding.btnFavFootball.setOnClickListener { toggleFavorite("Football", binding.btnFavFootball) }
        binding.btnFavBasketball.setOnClickListener { toggleFavorite("Basketball", binding.btnFavBasketball) }
        binding.btnFavVolleyball.setOnClickListener { toggleFavorite("Volleyball", binding.btnFavVolleyball) }
        binding.btnFavHockey.setOnClickListener { toggleFavorite("Hockey", binding.btnFavHockey) }
        binding.btnFavTennis.setOnClickListener { toggleFavorite("Tennis", binding.btnFavTennis) }
        binding.btnFavBadminton.setOnClickListener { toggleFavorite("Badminton", binding.btnFavBadminton) }
        binding.btnFavRugby.setOnClickListener { toggleFavorite("Rugby", binding.btnFavRugby) }
    }

    private fun updateFavoriteIcons() {
        val sports = listOf("Cricket", "Football", "Basketball", "Volleyball", "Hockey", "Tennis", "Badminton", "Rugby")
        val buttons = listOf(
            binding.btnFavCricket, binding.btnFavFootball, binding.btnFavBasketball, 
            binding.btnFavVolleyball, binding.btnFavHockey, binding.btnFavTennis, 
            binding.btnFavBadminton, binding.btnFavRugby
        )

        sports.forEachIndexed { index, sport ->
            val isFav = FavoriteManager.isFavorite(this, sport)
            buttons[index].setImageResource(
                if (isFav) android.R.drawable.btn_star_big_on else android.R.drawable.btn_star_big_off
            )
        }
    }

    private fun openSport(sport: String) {
        val i = Intent(this, SportDetailActivity::class.java)
        i.putExtra("sport_name", sport)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as androidx.appcompat.widget.SearchView
        searchView.queryHint = "Search Sports..."

        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                filterSports(newText)
                return true
            }
        })

        val themeItem = menu.findItem(R.id.action_theme)
        val switch = themeItem.actionView?.findViewById<Switch>(R.id.switch_theme)

        if (switch != null) {
            switch.isChecked = prefs.getBoolean("night_mode", false)
            switch.setOnCheckedChangeListener { _, isChecked ->
                prefs.edit().putBoolean("night_mode", isChecked).apply()
                AppCompatDelegate.setDefaultNightMode(
                    if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
                )
            }
        }

        return true
    }

    private fun toggleFavorite(sport: String, button: ImageButton) {
        if (FavoriteManager.isFavorite(this, sport)) {
            FavoriteManager.removeFavorite(this, sport)
            button.setImageResource(android.R.drawable.btn_star_big_off)
        } else {
            FavoriteManager.addFavorite(this, sport)
            button.setImageResource(android.R.drawable.btn_star_big_on)
        }
    }

    private fun filterSports(query: String?) {
        val text = query?.lowercase() ?: ""
        binding.apply {
            cardCricket.visibility = if ("cricket".contains(text)) View.VISIBLE else View.GONE
            cardFootball.visibility = if ("football".contains(text)) View.VISIBLE else View.GONE
            cardBasketball.visibility = if ("basketball".contains(text)) View.VISIBLE else View.GONE
            cardVolleyball.visibility = if ("volleyball".contains(text)) View.VISIBLE else View.GONE
            cardHockey.visibility = if ("hockey".contains(text)) View.VISIBLE else View.GONE
            cardTennis.visibility = if ("tennis".contains(text)) View.VISIBLE else View.GONE
            cardBadminton.visibility = if ("badminton".contains(text)) View.VISIBLE else View.GONE
            cardRugby.visibility = if ("rugby".contains(text)) View.VISIBLE else View.GONE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_favorites -> {
                startActivity(Intent(this, FavoritesActivity::class.java))
                true
            }
            R.id.action_quiz -> {
                startActivity(Intent(this, QuizActivity::class.java))
                true
            }
            R.id.action_live_score -> {
                val url = "https://www.google.com/search?q=live+sports+score"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
