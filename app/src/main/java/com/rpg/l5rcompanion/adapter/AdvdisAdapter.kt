package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.AdvDis


class AdvdisAdapter: RecyclerView.Adapter<AdvdisAdapter.AdvdisViewHolder>() {

    var dataset = ArrayList<AdvDis>()
    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    class AdvdisViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val descView: TextView = view.findViewById(R.id.item_desc)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(advdis: List<AdvDis>) {
        val sortedList = advdis.sortedBy { it.name }
        this.dataset= sortedList.toMutableList() as ArrayList<AdvDis>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvdisViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_schools, parent, false)

        return AdvdisViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdvdisViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleView.text =  item.name
        holder.descView.text = "Type : " + item.subtype + " | Cost : " + item.points
    }

    override fun getItemCount() = dataset.size
}