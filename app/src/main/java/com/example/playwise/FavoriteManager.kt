package com.example.playwise

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object FavoriteManager {
    private const val PREFS_NAME = "settings"
    private const val KEY_FAVORITES = "favorites"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getAllFavorites(context: Context): Set<String> {
        val favs = getPrefs(context).getStringSet(KEY_FAVORITES, emptySet()) ?: emptySet()
        Log.d("FAV_DEBUG", "Loaded Favorites: $favs")
        return favs
    }

    fun addFavorite(context: Context, sport: String) {
        val favs = getAllFavorites(context).toMutableSet()
        if (favs.add(sport)) {
            getPrefs(context).edit().putStringSet(KEY_FAVORITES, favs).apply()
            Log.d("FAV_DEBUG", "Added Favorite: $sport")
        }
    }

    fun removeFavorite(context: Context, sport: String) {
        val favs = getAllFavorites(context).toMutableSet()
        if (favs.remove(sport)) {
            getPrefs(context).edit().putStringSet(KEY_FAVORITES, favs).apply()
            Log.d("FAV_DEBUG", "Removed Favorite: $sport")
        }
    }

    fun isFavorite(context: Context, sport: String): Boolean {
        return getAllFavorites(context).contains(sport)
    }
}
