package com.example.playwise

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.playwise.databinding.ActivitySportDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SportDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySportDetailBinding
    private lateinit var sport: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        sport = intent.getStringExtra("sport_name") ?: "Sport"
        supportActionBar?.title = sport

        // Set header image
        val sportImage = when (sport.lowercase()) {
            "cricket" -> R.drawable.cricket
            "football" -> R.drawable.football
            "basketball" -> R.drawable.basketball
            "volleyball" -> R.drawable.vollyball
            "hockey" -> R.drawable.hockey
            "tennis" -> R.drawable.tennis
            "badminton" -> R.drawable.badminton
            "rugby" -> R.drawable.rugby
            else -> android.R.drawable.ic_menu_gallery
        }
        binding.headerImage.setImageResource(sportImage)
        binding.headerTitle.text = sport

        binding.btnRules.setOnClickListener {
            val i = Intent(this, RulesActivity::class.java)
            i.putExtra("sport_name", sport)
            startActivity(i)
        }

        binding.btnGround.setOnClickListener {
            val i = Intent(this, GroundActivity::class.java)
            i.putExtra("sport_name", sport)
            startActivity(i)
        }

        binding.btnTips.setOnClickListener {
            val i = Intent(this, TipsActivity::class.java)
            i.putExtra("sport_name", sport)
            startActivity(i)
        }

        binding.btnWatch.setOnClickListener {
            showVideoBottomSheet()
        }

        binding.btnLiveScore.setOnClickListener {
            val url = "https://www.google.com/search?q=$sport+live+score"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    private fun showVideoBottomSheet() {
        val videos = VideoRepository.getVideosForSport(sport)
        
        if (videos.isEmpty()) {
            Toast.makeText(this, "No videos available for $sport", Toast.LENGTH_SHORT).show()
            return
        }

        val bottomSheetDialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_video_list, null)
        
        val rvVideos = view.findViewById<RecyclerView>(R.id.rvVideos)
        val adapter = VideoAdapter(videos) { video ->
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.url))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Could not open video", Toast.LENGTH_SHORT).show()
            }
            bottomSheetDialog.dismiss()
        }
        
        rvVideos.adapter = adapter
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                val shareText = "Check out $sport on PlayWise App!"
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, shareText)
                }
                startActivity(Intent.createChooser(shareIntent, "Share via"))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
