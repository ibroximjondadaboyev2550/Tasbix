package com.example.tasbix2024.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tasbix2024.R

class DuaListAdapter(
    private val duaList: List<String>
) : RecyclerView.Adapter<DuaListAdapter.DuaViewHolder>() {

    // ViewHolder klassi
    class DuaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val duaText: TextView = itemView.findViewById(R.id.duaTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DuaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dua, parent, false)
        return DuaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DuaViewHolder, position: Int) {
        holder.duaText.text = duaList[position]
    }

    override fun getItemCount(): Int {
        return duaList.size
    }
}
