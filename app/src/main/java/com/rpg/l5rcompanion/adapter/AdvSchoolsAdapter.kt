package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Schools

class AdvSchoolsAdapter: RecyclerView.Adapter<AdvSchoolsAdapter.AdvSchoolsViewHolder>() {

    var dataset = ArrayList<Schools>()
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    class AdvSchoolsViewHolder(view: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val descView: TextView = view.findViewById(R.id.item_desc)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(schools: List<Schools>) {
        val sortedList = schools.sortedBy { it.name }
        this.dataset = sortedList.toMutableList() as ArrayList<Schools>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvSchoolsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_schools, parent, false)

        return AdvSchoolsViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdvSchoolsViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleView.text = item.name
        holder.descView.text = item.discipline
    }

    override fun getItemCount() = dataset.size
}