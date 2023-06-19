package com.rpg.l5rcompanion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rpg.l5rcompanion.adapter.KatasAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListKatasBinding


class ListKatasFragment : Fragment() {

    private var adapter = KatasAdapter()
    private lateinit var binding: FragmentListKatasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListKatasBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val itemList = db.l5rCompanionDao().getAllKatas()
        adapter.setDataList(itemList)

        /*spinner*/
        val katas = resources.getStringArray(R.array.katas)
        val spinner: Spinner = binding.spinner

        val mArrayAdapter = ArrayAdapter<Any?>(activity as AppCompatActivity, android.R.layout.simple_spinner_dropdown_item, katas)
        spinner.adapter = mArrayAdapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View?, position: Int, id: Long) {
                val category = katas[position]

                if(category == "Air"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getKatasByRing(ring = "Air")
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Earth"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getKatasByRing(ring = "Earth")
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Fire"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getKatasByRing(ring = "Fire")
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Void"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getKatasByRing(ring = "Void")
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Water"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getKatasByRing(ring = "Water")
                    adapter.setDataList(itemListFilter)
                }

                if(category == "All Spells"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getAllKatas()
                    adapter.setDataList(itemListFilter)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {


            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setOnItemClickListener(object : KatasAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                view.findNavController().navigate(ListKatasFragmentDirections.actionListKatasFragmentToDetailKatasFragment(uid))
            }
        })
    }
}