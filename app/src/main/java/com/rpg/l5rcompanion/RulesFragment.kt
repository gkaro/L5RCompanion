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
import com.rpg.l5rcompanion.adapter.RulesAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {

    private var adapter = RulesAdapter()
    private lateinit var binding: FragmentRulesBinding
    private val args: RulesFragmentArgs by this.navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRulesBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        val catRules = args.uid
        val itemList = db.l5rCompanionDao().getRulesByCategory(uid = catRules)
        adapter.setDataList(itemList)

        adapter.setOnItemClickListener(object : RulesAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                findNavController().navigate(RulesFragmentDirections.actionRulesFragmentToDetailRulesFragment(uid))
            }
        })

        return binding.root
    }


}