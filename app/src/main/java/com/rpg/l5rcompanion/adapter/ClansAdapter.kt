package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Clans

class ClansAdapter: RecyclerView.Adapter<ClansAdapter.ClansViewHolder>() {

    var dataset = ArrayList<Clans>()
    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    class ClansViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(clans: List<Clans>) {
        //val sortedList = clans.sortedBy { it.name }
        this.dataset= clans.toMutableList() as ArrayList<Clans>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClansViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_clans, parent, false)

        return ClansViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ClansViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  item.name
    }

    override fun getItemCount() = dataset.size
}