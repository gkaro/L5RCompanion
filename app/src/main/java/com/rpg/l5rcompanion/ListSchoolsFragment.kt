package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rpg.l5rcompanion.adapter.ClansAdapter
import com.rpg.l5rcompanion.adapter.SchoolsAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListSchoolsBinding


class ListSchoolsFragment : Fragment(R.layout.fragment_list_schools) {

    private var adapter = SchoolsAdapter()
    private lateinit var binding: FragmentListSchoolsBinding
    private val args: ListSchoolsFragmentArgs by this.navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListSchoolsBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val idClan = args.uid
        val itemList = db.l5rCompanionDao().getBasicSchoolsFromClan(uid = idClan)
        adapter.setDataList(itemList)

        adapter.setOnItemClickListener(object : SchoolsAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                findNavController().navigate(ListSchoolsFragmentDirections.actionListSchoolsFragmentToDetailSchoolFragment(uid))
            }
        })
        return binding.root
    }


}