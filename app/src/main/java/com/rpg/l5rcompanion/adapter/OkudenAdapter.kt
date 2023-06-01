package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Okuden

class OkudenAdapter : RecyclerView.Adapter<OkudenAdapter.OkudenViewHolder>() {

    var dataset = ArrayList<Okuden>()
    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    class OkudenViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view){
        val titleView: TextView = view.findViewById(R.id.item_title)
        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(okuden: List<Okuden>){
        val sortedList = okuden.sortedBy { it.name }
        this.dataset = sortedList.toMutableList() as ArrayList<Okuden>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OkudenViewHolder{
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return OkudenViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: OkudenViewHolder, position: Int){
        val item = dataset[position]
        holder.titleView.text =  item.name
    }

    override fun getItemCount() = dataset.size
}