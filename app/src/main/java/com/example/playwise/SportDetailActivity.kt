package com.example.playwise

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.playwise.databinding.ActivitySportDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Locale

class SportDetailActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var binding: ActivitySportDetailBinding
    private lateinit var sport: String
    private var tts: TextToSpeech? = null
    private var isReading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        sport = intent.getStringExtra("sport_name") ?: "Sport"
        supportActionBar?.title = sport

        // Set header image and rules text
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
        binding.tvRules.text = getRulesForSport(sport)

        // Initialize TextToSpeech
        tts = TextToSpeech(this, this)

        binding.btnSpeak.setOnClickListener {
            toggleReading()
        }

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

    private fun toggleReading() {
        if (isReading) {
            tts?.stop()
            isReading = false
            binding.btnSpeak.setImageResource(android.R.drawable.ic_lock_silent_mode_off)
        } else {
            val textToRead = binding.tvRules.text.toString()
            if (textToRead.isNotEmpty()) {
                tts?.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, null)
                isReading = true
                binding.btnSpeak.setImageResource(android.R.drawable.ic_lock_silent_mode)
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.US) ?: TextToSpeech.LANG_NOT_SUPPORTED
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The Language specified is not supported!")
            }
        } else {
            Log.e("TTS", "Initialization Failed!")
        }
    }

    override fun onDestroy() {
        tts?.stop()
        tts?.shutdown()
        super.onDestroy()
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
                val rulesText = binding.tvRules.text.toString()
                val sportName = sport

                val shareText = "Check out the rules for $sportName:\n\n$rulesText\n\nShared via PlayWise App"

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

    private fun getRulesForSport(sport: String): String {
        return when (sport.lowercase()) {
            "cricket" -> "Cricket is a bat-and-ball game played between two teams of eleven players on a field at the center of which is a 20-metre (22-yard) pitch with a wicket at each end, each comprising two bails balanced on three stumps. The batting side scores runs by striking the ball bowled at the wicket with the bat, while the bowling and fielding side tries to prevent this and dismiss each player (so they are 'out')."
            "football" -> "Football, also called soccer, is a game in which two teams of 11 players, using any part of their bodies except their hands and arms, try to maneuver the ball into the opposing team’s goal. Only the goalkeeper is permitted to handle the ball and may do so only within the penalty area surrounding the goal. The team that scores more goals wins."
            else -> "Rules for this sport are not available yet."
        }
    }
}