package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Paths


class PathsAdapter: RecyclerView.Adapter<PathsAdapter.PathsViewHolder>() {

    var dataset = ArrayList<Paths>()
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    class PathsViewHolder(view: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val descView: TextView = view.findViewById(R.id.item_desc)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(schools: List<Paths>) {
        val sortedList = schools.sortedBy { it.name }
        this.dataset = sortedList.toMutableList() as ArrayList<Paths>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PathsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_schools, parent, false)

        return PathsViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PathsViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleView.text = item.name
        holder.descView.text = "replaces : " + item.replaces
    }

    override fun getItemCount() = dataset.size
}