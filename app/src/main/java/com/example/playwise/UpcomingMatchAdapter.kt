package com.example.playwise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.playwise.databinding.ItemMatchUpcomingBinding

class UpcomingMatchAdapter(
    private val matches: List<Match>,
    private val onCalendarClick: (Match) -> Unit
) : RecyclerView.Adapter<UpcomingMatchAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemMatchUpcomingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMatchUpcomingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = matches[position]
        holder.binding.textMatchName.text = match.title
        holder.binding.textMatchDate.text = match.date
        holder.binding.btnAddCalendar.setOnClickListener { onCalendarClick(match) }
        
        holder.itemView.setOnClickListener {
            it.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
            }.start()
        }
    }

    override fun getItemCount() = matches.size
}
