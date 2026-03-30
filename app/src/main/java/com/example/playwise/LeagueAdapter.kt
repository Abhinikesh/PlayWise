package com.example.playwise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class LeagueAdapter(
    private val items: List<TicketItem>,
    private val onItemClick: (TicketItem) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val card: MaterialCardView = view.findViewById(R.id.leagueCard)
        val image: ImageView = view.findViewById(R.id.leagueImage)
        val name: TextView = view.findViewById(R.id.leagueName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_league, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.image.setImageResource(item.iconRes)
        
        holder.card.setOnClickListener {
            it.animate().scaleX(1.05f).scaleY(1.05f).setDuration(100).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                onItemClick(item)
            }.start()
        }
    }

    override fun getItemCount() = items.size
}
