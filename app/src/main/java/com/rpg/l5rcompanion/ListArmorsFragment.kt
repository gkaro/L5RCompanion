package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rpg.l5rcompanion.adapter.ArmorsAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListArmorsBinding

class ListArmorsFragment : Fragment() {

    private var adapter = ArmorsAdapter()
    private lateinit var binding: FragmentListArmorsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListArmorsBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val itemList = db.l5rCompanionDao().getAllArmors()
        adapter.setDataList(itemList)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setOnItemClickListener(object : ArmorsAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                view.findNavController().navigate(ListArmorsFragmentDirections.actionListArmorsFragmentToDetailArmorsFragment(uid))
            }
        })
    }
}