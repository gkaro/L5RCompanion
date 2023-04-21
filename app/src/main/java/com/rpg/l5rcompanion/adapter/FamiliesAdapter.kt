package com.rpg.l5rcompanion.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rpg.l5rcompanion.R
import com.rpg.l5rcompanion.database.Clans
import com.rpg.l5rcompanion.database.Families


class FamiliesAdapter: RecyclerView.Adapter<FamiliesAdapter.FamiliesViewHolder>() {

    var dataset = ArrayList<Families>()
    //private lateinit var mListener : AdapterView.OnItemClickListener

    /* interface OnItemClickListener : AdapterView.OnItemClickListener {
         fun OnItemClick(position: Int)
         abstract fun onItemClick(adapterPosition: Int)
     }

     fun setOnItemClickListener(listener: OnItemClickListener){
         mListener = listener
     }*/


    class FamiliesViewHolder(view: View, ) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        //val bonusView: TextView = view.findViewById(R.id.item_bonus)
        init{
            itemView.setOnClickListener{
                // listener.onItemClick(adapterPosition)
            }
        }
    }

    fun setDataList(families: List<Families>) {

        this.dataset= families.toMutableList() as ArrayList<Families>

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamiliesViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_families, parent, false)

        return FamiliesViewHolder(adapterLayout)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FamiliesViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  item.name + " : " + item.bonus
        //holder.bonusView.text = item.bonus

    }

    override fun getItemCount() = dataset.size
}