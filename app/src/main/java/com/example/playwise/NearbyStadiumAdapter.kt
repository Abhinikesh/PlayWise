package com.example.playwise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.playwise.databinding.ItemStadiumNearbyBinding

class NearbyStadiumAdapter(
    private val stadiums: List<Stadium>,
    private val onBookClick: (Stadium) -> Unit
) : RecyclerView.Adapter<NearbyStadiumAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemStadiumNearbyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemStadiumNearbyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stadium = stadiums[position]
        holder.binding.textStadiumName.text = stadium.name
        holder.binding.textStadiumCity.text = stadium.city
        holder.binding.btnBookStadium.setOnClickListener { onBookClick(stadium) }
        
        holder.itemView.setOnClickListener {
            it.animate().scaleX(0.98f).scaleY(0.98f).setDuration(100).withEndAction {
                it.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
            }.start()
        }
    }

    override fun getItemCount() = stadiums.size
}

data class Stadium(val name: String, val city: String)
