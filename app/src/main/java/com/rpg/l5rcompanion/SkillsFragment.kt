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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rpg.l5rcompanion.adapter.SkillsAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentSkillsBinding

class SkillsFragment : Fragment() {

    private var adapter = SkillsAdapter()
    private lateinit var binding: FragmentSkillsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkillsBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val itemList = db.l5rCompanionDao().getAllSkills()
        adapter.setDataList(itemList)

        /*spinner*/
        val skills = resources.getStringArray(R.array.skills)
        val spinner: Spinner = binding.spinner

        val mArrayAdapter = ArrayAdapter<Any?>(activity as AppCompatActivity, android.R.layout.simple_spinner_dropdown_item, skills)
        spinner.adapter = mArrayAdapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View?, position: Int, id: Long) {
                val category = skills[position]

               if(category == "High Skills"){
                adapter.notifyDataSetChanged()
                   val itemListFilter = db.l5rCompanionDao().getSkillsByCategory(uid = 1)
                   adapter.setDataList(itemListFilter)
               }
                if(category == "Bugei Skills"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSkillsByCategory(uid = 2)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Merchant Skills"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSkillsByCategory(uid = 3)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Low Skills"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSkillsByCategory(uid = 4)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "All Skills"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getAllSkills()
                    adapter.setDataList(itemListFilter)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                val itemList = db.l5rCompanionDao().getAllSkills()
                adapter.setDataList(itemList)
            }
        }


        adapter.setOnItemClickListener(object : SkillsAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                findNavController().navigate(SkillsFragmentDirections.actionSkillsFragmentToDetailSkillsFragment(uid))
            }
        })

        return binding.root
    }
}