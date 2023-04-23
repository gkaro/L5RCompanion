package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Schools

class SchoolsAdapter: RecyclerView.Adapter<SchoolsAdapter.SchoolsViewHolder>() {

    var dataset = ArrayList<Schools>()
    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    class SchoolsViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val descView: TextView = view.findViewById(R.id.item_desc)
        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(schools: List<Schools>) {
        this.dataset= schools.toMutableList() as ArrayList<Schools>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_schools, parent, false)

        return SchoolsViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SchoolsViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleView.text =  item.name
        holder.descView.text = item.benefit + "/" + item.discipline + "/" + item.honor

    }

    override fun getItemCount() = dataset.size
}