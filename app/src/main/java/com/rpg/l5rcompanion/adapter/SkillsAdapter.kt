package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Skills


class SkillsAdapter: RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder>() {

    var dataset = ArrayList<Skills>()
    private lateinit var mListener : OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }


    class SkillsViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val firstDescView: TextView = view.findViewById(R.id.item_desc)
        val secondDescView: TextView = view.findViewById(R.id.item_desc2)
        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(skills: List<Skills>) {
        val sortedList = skills.sortedBy { it.name }
        this.dataset= sortedList.toMutableList() as ArrayList<Skills>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_skills, parent, false)

        return SkillsViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleView.text =  item.name
        holder.firstDescView.text =  "(" + item.trait + ")"
        holder.secondDescView.text =  "Emphases : " + item.emphases
    }

    override fun getItemCount() = dataset.size
}