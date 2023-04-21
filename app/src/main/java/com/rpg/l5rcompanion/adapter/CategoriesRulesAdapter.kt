package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.CategoriesRules


class CategoriesRulesAdapter: RecyclerView.Adapter<CategoriesRulesAdapter.CategoriesRulesViewHolder>(){

    var dataset = ArrayList<CategoriesRules>()
    private lateinit var mListener : OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    class CategoriesRulesViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(absoluteAdapterPosition)
            }
        }
    }

    fun setDataList(categoriesRules: List<CategoriesRules>) {
        this.dataset= categoriesRules.toMutableList() as ArrayList<CategoriesRules>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesRulesViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return CategoriesRulesViewHolder(adapterLayout, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CategoriesRulesViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  item.name
    }

    override fun getItemCount() = dataset.size
}