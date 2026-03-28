package com.example.playwise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class FavoriteAdapter(
    private var favorites: MutableList<String>,
    private val onDetailsClick: (String) -> Unit,
    private val onWatchClick: (String) -> Unit,
    private val onQuizClick: (String) -> Unit,
    private val onRemoveClick: (String) -> Unit
) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivSportImage: ImageView = view.findViewById(R.id.ivSportImage)
        val tvSportName: TextView = view.findViewById(R.id.tvSportName)
        val btnRemoveFav: ImageButton = view.findViewById(R.id.btnRemoveFav)
        val btnDetails: MaterialButton = view.findViewById(R.id.btnDetails)
        val btnWatch: MaterialButton = view.findViewById(R.id.btnWatch)
        val btnQuiz: MaterialButton = view.findViewById(R.id.btnQuiz)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val sport = favorites[position]
        holder.tvSportName.text = sport
        
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
        holder.ivSportImage.setImageResource(sportImage)

        holder.btnDetails.setOnClickListener { onDetailsClick(sport) }
        holder.btnWatch.setOnClickListener { onWatchClick(sport) }
        holder.btnQuiz.setOnClickListener { onQuizClick(sport) }
        
        holder.btnRemoveFav.setOnClickListener {
            // Simple removal animation logic could be added here
            onRemoveClick(sport)
        }

        // Add a simple entrance animation
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, android.R.anim.fade_in)
        
        // Scale effect on click
        holder.itemView.setOnClickListener {
            it.animate().scaleX(0.98f).scaleY(0.98f).setDuration(100).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                onDetailsClick(sport)
            }.start()
        }
    }

    override fun getItemCount() = favorites.size

    fun updateData(newFavorites: List<String>) {
        favorites.clear()
        favorites.addAll(newFavorites)
        notifyDataSetChanged()
    }
}
