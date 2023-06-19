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

        val ringid = args.ring
        val itemList = db.l5rCompanionDao().getSpellsByRing(ringid)
        adapter.setDataList(itemList)

        /*spinner*/
        val spells = resources.getStringArray(R.array.spells)
        val spinner: Spinner = binding.spinner

        val mArrayAdapter = ArrayAdapter<Any?>(activity as AppCompatActivity, android.R.layout.simple_spinner_dropdown_item, spells)
        spinner.adapter = mArrayAdapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View?, position: Int, id: Long) {
                val category = spells[position]

                if(category == "Mastery level 1"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSpellsByMasteryandRing(uid = 1, ringid)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Mastery level 2"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSpellsByMasteryandRing(uid = 2, ringid)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Mastery level 3"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSpellsByMasteryandRing(uid = 3, ringid)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Mastery level 4"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSpellsByMasteryandRing(uid = 4, ringid)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Mastery level 5"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSpellsByMasteryandRing(uid = 5, ringid)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "Mastery level 6"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSpellsByMasteryandRing(uid = 6, ringid)
                    adapter.setDataList(itemListFilter)
                }
                if(category == "All Spells"){
                    adapter.notifyDataSetChanged()
                    val itemListFilter = db.l5rCompanionDao().getSpellsByRing(ringid)
                    adapter.setDataList(itemListFilter)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                val ringId = args.ring
                val itemList = db.l5rCompanionDao().getSpellsByRing(ringId)
                adapter.setDataList(itemList)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setOnItemClickListener(object : SpellsAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                val ring = adapter.dataset[position].ring.toInt()
                view.findNavController().navigate(ListSpellsFragmentDirections.actionListSpellsFragmentToDetailSpellsFragment(uid, ring))
            }
        })
    }
}