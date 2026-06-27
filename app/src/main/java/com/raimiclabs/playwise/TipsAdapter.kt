package com.raimiclabs.playwise

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raimiclabs.playwise.databinding.ItemTipBinding

class TipsAdapter(private val tips: List<TipItem>) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    class TipViewHolder(val binding: ItemTipBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val binding = ItemTipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        holder.binding.tvTipTitle.text = tip.title
        holder.binding.tvTipDescription.text = tip.description
    }

    override fun getItemCount(): Int = tips.size
}
