package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Kihos


class KihosAdapter: RecyclerView.Adapter<KihosAdapter.KihosViewHolder>() {

    var dataset = ArrayList<Kihos>()
    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    class KihosViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val descView: TextView = view.findViewById(R.id.item_desc)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(kihos: List<Kihos>) {

        val sortedList = kihos.sortedBy { it.name }
        this.dataset= sortedList.toMutableList() as ArrayList<Kihos>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KihosViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_schools, parent, false)

        return KihosViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: KihosViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleView.text =  item.name
        holder.descView.text = "Ring of " + item.ring +  " | Mastery level " + item.mastery
    }

    override fun getItemCount() = dataset.size
}