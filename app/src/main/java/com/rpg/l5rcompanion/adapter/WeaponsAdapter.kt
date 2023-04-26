package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Weapons

class WeaponsAdapter: RecyclerView.Adapter<WeaponsAdapter.WeaponsViewHolder>() {

    var dataset = ArrayList<Weapons>()
    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    class WeaponsViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(weapons: List<Weapons>) {
        this.dataset= weapons.toMutableList() as ArrayList<Weapons>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return WeaponsViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WeaponsViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  item.name
    }

    override fun getItemCount() = dataset.size
}