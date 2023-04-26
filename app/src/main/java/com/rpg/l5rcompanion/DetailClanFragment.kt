package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rpg.l5rcompanion.R.id.clanDescription
import com.rpg.l5rcompanion.adapter.FamiliesAdapter
import com.rpg.l5rcompanion.database.Clans
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentDetailClanBinding


class DetailClanFragment : Fragment(R.layout.fragment_detail_clan) {

    private val args: DetailClanFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailClanBinding
    private var adapter = FamiliesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailClanBinding.inflate(layoutInflater)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val uid = args.uid
        val item = getDetailsFromClan(uid)
        val nameClan = item.first().name
        val imageItem = item.first().mon
        val descriptionClan = item.first().description

        val name: TextView = view.findViewById(R.id.clanName)
        name.text = nameClan
        val image: ImageView = view.findViewById(R.id.image)
        val description: TextView = view.findViewById(clanDescription)
        description.text = descriptionClan
        val int = resources.getIdentifier(imageItem,"drawable", "com.rpg.l5rcompanion")
        image.setImageResource(int)

        /**display or hide description*/
        val seeDesc :TextView = view.findViewById(clanDescription)
        seeDesc.visibility = View.GONE
        val show: Button = view.findViewById(R.id.seemore)
        val hide: Button = view.findViewById(R.id.seeless)
        hide.visibility = View.GONE

        show.setOnClickListener {
            seeDesc.visibility = View.VISIBLE
            hide.visibility = View.VISIBLE
            show.visibility = View.GONE
        }
        hide.setOnClickListener {
            seeDesc.visibility = View.GONE
            hide.visibility = View.GONE
            show.visibility = View.VISIBLE
        }


        binding.basicSchools.setOnClickListener{
            view.findNavController().navigate(DetailClanFragmentDirections.actionDetailClanFragmentToListSchoolsFragment(uid))
        }

        binding.advancedSchools.setOnClickListener {
            view.findNavController().navigate(DetailClanFragmentDirections.actionDetailClanFragmentToListAdvSchoolsFragment(uid))
        }

        binding.paths.setOnClickListener {
            view.findNavController().navigate(DetailClanFragmentDirections.actionDetailClanFragmentToListPathsFragment(uid))
        }
    }

    private fun getDetailsFromClan(uid: Int): List<Clans> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getDetailsFromClan(uid = uid)
    }
}