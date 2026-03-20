package com.example.playwise

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val favSet = prefs.getStringSet("favorites", emptySet()) ?: emptySet()

        val tv = findViewById<TextView>(R.id.tvFavorites)
        tv.text = if (favSet.isEmpty())
            "No favorites selected"
        else
            favSet.joinToString("\n")
    }
}