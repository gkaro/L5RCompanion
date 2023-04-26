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
import com.rpg.l5rcompanion.adapter.PathsAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListPathsBinding

class ListPathsFragment : Fragment(R.layout.fragment_list_paths) {

    private var adapter = PathsAdapter()
    private lateinit var binding: FragmentListPathsBinding
    private val args: ListPathsFragmentArgs by this.navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListPathsBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val idClan = args.uid
        val itemList = db.l5rCompanionDao().getPathsFromClan(uid = idClan)
        adapter.setDataList(itemList)

        adapter.setOnItemClickListener(object : PathsAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                findNavController().navigate(ListPathsFragmentDirections.actionListPathsFragmentToDetailPathFragment(uid))
            }
        })

        return binding.root
    }


}