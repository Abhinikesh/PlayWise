package com.example.playwise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroundAdapter(private val grounds: List<GroundActivity.Ground>) : RecyclerView.Adapter<GroundAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ground, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ground = grounds[position]
        holder.groundName.text = ground.name
        holder.groundDetails.text = ground.details
        holder.groundImage.setImageResource(ground.image)
    }

    override fun getItemCount() = grounds.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val groundImage: ImageView = itemView.findViewById(R.id.ground_image)
        val groundName: TextView = itemView.findViewById(R.id.ground_name)
        val groundDetails: TextView = itemView.findViewById(R.id.ground_details)
    }
}