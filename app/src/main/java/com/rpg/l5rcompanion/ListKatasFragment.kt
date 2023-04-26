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