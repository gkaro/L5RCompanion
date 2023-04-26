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
import com.rpg.l5rcompanion.adapter.WeaponsAdapter
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentListWeaponsBinding

class ListWeaponsFragment : Fragment() {

    private var adapter = WeaponsAdapter()
    private lateinit var binding: FragmentListWeaponsBinding
    private val args: ListWeaponsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListWeaponsBinding.inflate(layoutInflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val uid = args.uid

        if(uid == 2){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Arrow")
            adapter.setDataList(itemList)
        }
        if(uid == 3){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Bows")
            adapter.setDataList(itemList)
        }
        if(uid == 4){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Chains")
            adapter.setDataList(itemList)
        }
        if(uid == 5){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Firearms")
            adapter.setDataList(itemList)
        }
        if(uid == 6){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Heavy")
            adapter.setDataList(itemList)
        }
        if(uid == 7){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Knives")
            adapter.setDataList(itemList)
        }
        if(uid == 8){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Ninjutsu")
            adapter.setDataList(itemList)
        }
        if(uid == 9){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Polearms")
            adapter.setDataList(itemList)
        }
        if(uid == 10){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Sling")
            adapter.setDataList(itemList)
        }
        if(uid == 11){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Spears")
            adapter.setDataList(itemList)
        }
        if(uid == 12){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Staves")
            adapter.setDataList(itemList)
        }
        if(uid == 13){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "Sword")
            adapter.setDataList(itemList)
        }
        if(uid == 14){
            val itemList = db.l5rCompanionDao().getWeaponsByType(type = "War Fan")
            adapter.setDataList(itemList)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setOnItemClickListener(object : WeaponsAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                val uid = adapter.dataset[position].uid
                view.findNavController().navigate(ListWeaponsFragmentDirections.actionListWeaponsFragmentToDetailWeaponsFragment(uid))
            }
        })
    }
}