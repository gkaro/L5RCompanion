package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Katas

class KatasAdapter: RecyclerView.Adapter<KatasAdapter.KatasViewHolder>() {

    var dataset = ArrayList<Katas>()
    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    class KatasViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val descView: TextView = view.findViewById(R.id.item_desc)
        val descView2: TextView = view.findViewById(R.id.item_desc2)
        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(katas: List<Katas>) {
        val sortedList = katas.sortedBy { it.name }
        this.dataset= sortedList.toMutableList() as ArrayList<Katas>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KatasViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_skills, parent, false)

        return KatasViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: KatasViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleView.text =  item.name
        holder.descView.text = "Ring of " + item.ring +  " | Mastery level " + item.mastery
        holder.descView2.text = item.schools
    }

    override fun getItemCount() = dataset.size
}