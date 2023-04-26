package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rpg.l5rcompanion.adapter.SpellsAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListSpellsBinding

class ListSpellsFragment : Fragment() {

    private lateinit var binding: FragmentListSpellsBinding
    private var adapter = SpellsAdapter()
    private val args: ListSpellsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListSpellsBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        val uid = args.mastery
        val ring = args.ring
        val itemList = db.l5rCompanionDao().getSpellsByMasteryandRing(uid,ring)
        adapter.setDataList(itemList)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setOnItemClickListener(object : SpellsAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                view.findNavController().navigate(ListSpellsFragmentDirections.actionListSpellsFragmentToDetailSpellsFragment(uid))
            }
        })
    }
}