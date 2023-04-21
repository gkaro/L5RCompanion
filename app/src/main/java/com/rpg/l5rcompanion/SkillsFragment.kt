package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rpg.l5rcompanion.adapter.SchoolsAdapter
import com.rpg.l5rcompanion.adapter.SkillsAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListSkillsBinding
import com.rpg.l5rcompanion.databinding.FragmentSkillsBinding


class SkillsFragment : Fragment() {

    private var adapter = SkillsAdapter()
    private lateinit var binding: FragmentSkillsBinding
    private val args: SkillsFragmentArgs by this.navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSkillsBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val idCategory = args.uid
        val itemList = db.l5rCompanionDao().getSkillsByCategory(uid = idCategory)
        adapter.setDataList(itemList)

        adapter.setOnItemClickListener(object : SkillsAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                findNavController().navigate(SkillsFragmentDirections.actionSkillsFragmentToDetailSkillsFragment(uid))
            }
        })

        return binding.root
    }
}