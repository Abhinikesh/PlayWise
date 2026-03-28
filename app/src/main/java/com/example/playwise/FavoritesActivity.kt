package com.example.playwise

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playwise.quiz.QuizActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton

class FavoritesActivity : AppCompatActivity() {

    private lateinit var rvFavorites: RecyclerView
    private lateinit var adapter: FavoriteAdapter
    private lateinit var tvFavCount: TextView
    private lateinit var emptyState: View
    private lateinit var btnExplore: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        // Initialize Views
        rvFavorites = findViewById(R.id.rvFavorites)
        tvFavCount = findViewById(R.id.tvFavCount)
        emptyState = findViewById(R.id.emptyState)
        btnExplore = findViewById(R.id.btnExplore)

        setupRecyclerView()
        setupBottomNavigation()

        btnExplore.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        // Always load fresh data when the screen becomes visible
        loadFavorites()
    }

    private fun setupRecyclerView() {
        rvFavorites.layoutManager = LinearLayoutManager(this)
        adapter = FavoriteAdapter(
            mutableListOf(),
            onDetailsClick = { sport -> navigateToDetails(sport) },
            onWatchClick = { sport -> showVideoBottomSheet(sport) },
            onQuizClick = { sport -> navigateToQuiz(sport) },
            onRemoveClick = { sport -> removeFavorite(sport) }
        )
        rvFavorites.adapter = adapter
    }

    private fun loadFavorites() {
        // Load fresh data from FavoriteManager
        val favSet = FavoriteManager.getAllFavorites(this)
        val favList = favSet.toList().sorted()
        
        Log.d("FAV_DEBUG", "Activity Loading Favorites: $favSet")

        adapter.updateData(favList)
        
        val countText = if (favList.size == 1) "1 Sport saved" else "${favList.size} Sports saved"
        tvFavCount.text = countText
        
        if (favList.isEmpty()) {
            emptyState.visibility = View.VISIBLE
            rvFavorites.visibility = View.GONE
        } else {
            emptyState.visibility = View.GONE
            rvFavorites.visibility = View.VISIBLE
        }
    }

    private fun removeFavorite(sport: String) {
        FavoriteManager.removeFavorite(this, sport)
        loadFavorites() // Refresh UI immediately
        Toast.makeText(this, "$sport removed from favorites", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToDetails(sport: String) {
        val intent = Intent(this, SportDetailActivity::class.java)
        intent.putExtra("sport_name", sport)
        startActivity(intent)
    }

    private fun navigateToQuiz(sport: String) {
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("sport_name", sport)
        startActivity(intent)
    }

    private fun showVideoBottomSheet(sport: String) {
        val videos = VideoRepository.getVideosForSport(sport)
        
        if (videos.isEmpty()) {
            Toast.makeText(this, "No videos available for $sport", Toast.LENGTH_SHORT).show()
            return
        }

        val bottomSheetDialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_video_list, null)
        
        val rvVideos = view.findViewById<RecyclerView>(R.id.rvVideos)
        val videoAdapter = VideoAdapter(videos) { video ->
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.url))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Could not open video", Toast.LENGTH_SHORT).show()
            }
            bottomSheetDialog.dismiss()
        }
        
        rvVideos.adapter = videoAdapter
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }

    private fun setupBottomNavigation() {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_favorites
        
        bottomNav.post {
            animateBottomNavigationItem(bottomNav, R.id.nav_favorites)
        }

        bottomNav.setOnItemSelectedListener { item ->
            animateBottomNavigationItem(bottomNav, item.itemId)
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
                    true
                }
                R.id.nav_live -> {
                    val url = "https://www.google.com/search?q=live+sports+score"
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    false
                }
                R.id.nav_favorites -> true
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
            val view = bottomNav.findViewById<View>(id)
            if (id == itemId) {
                view?.animate()
                    ?.scaleX(1.15f)
                    ?.scaleY(1.15f)
                    ?.setDuration(200)
                    ?.start()
            } else {
                view?.animate()
                    ?.scaleX(1.0f)
                    ?.scaleY(1.0f)
                    ?.setDuration(200)
                    ?.start()
            }
        }
    }
}
