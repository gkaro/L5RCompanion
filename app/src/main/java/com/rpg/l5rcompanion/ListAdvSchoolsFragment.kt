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
import com.rpg.l5rcompanion.adapter.AdvSchoolsAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListAdvSchoolsBinding

class ListAdvSchoolsFragment : Fragment(R.layout.fragment_list_adv_schools) {

    private var adapter = AdvSchoolsAdapter()
    private lateinit var binding: FragmentListAdvSchoolsBinding
    private val args: ListAdvSchoolsFragmentArgs by this.navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListAdvSchoolsBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val idClan = args.uid
        val itemList = db.l5rCompanionDao().getAdvSchoolsFromClan(uid = idClan)
        adapter.setDataList(itemList)

        adapter.setOnItemClickListener(object : AdvSchoolsAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                findNavController().navigate(ListAdvSchoolsFragmentDirections.actionListAdvSchoolsFragmentToDetailAdvSchoolFragment(uid))
            }
        })

        return binding.root
    }
}