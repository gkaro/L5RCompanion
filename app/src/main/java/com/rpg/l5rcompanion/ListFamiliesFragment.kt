package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rpg.l5rcompanion.adapter.ClansAdapter
import com.rpg.l5rcompanion.adapter.FamiliesAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListClansBinding
import com.rpg.l5rcompanion.databinding.FragmentListFamiliesBinding


class ListFamiliesFragment : Fragment(R.layout.fragment_list_families) {

    private var adapter = FamiliesAdapter()
    private lateinit var binding: FragmentListFamiliesBinding
    private val args: ListFamiliesFragmentArgs by this.navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListFamiliesBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val idClan = args.uid
        val itemList = db.l5rCompanionDao().getFamiliesByClan(uid = idClan)
        adapter.setDataList(itemList)
        return binding.root
    }
}