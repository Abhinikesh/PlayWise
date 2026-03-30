package com.example.playwise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.playwise.databinding.ItemMatchTrendingBinding

class TrendingMatchAdapter(
    private val matches: List<Match>,
    private val onBookClick: (Match) -> Unit
) : RecyclerView.Adapter<TrendingMatchAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemMatchTrendingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMatchTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matches[position]
        holder.binding.textSport.text = match.sport.uppercase()
        holder.binding.textMatchTitle.text = match.title
        holder.binding.textDate.text = match.date
        holder.binding.btnBookNow.setOnClickListener { onBookClick(match) }
        
        holder.itemView.setOnClickListener {
            it.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
            }.start()
        }
    }

    override fun getItemCount() = matches.size
}
