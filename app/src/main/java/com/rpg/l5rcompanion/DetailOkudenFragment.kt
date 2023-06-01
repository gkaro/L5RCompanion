package com.rpg.l5rcompanion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.database.Okuden
import com.rpg.l5rcompanion.databinding.FragmentDetailOkudenBinding

class DetailOkudenFragment : Fragment() {

    private val args: DetailOkudenFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailOkudenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailOkudenBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        /**list of items from database */
        val uid = args.uid
        val item = getOkuden(uid)
        val nameOkuden = item.first().name
        val prerequisiteOkuden = item.first().prerequisite
        val rank1Okuden = item.first().rank1
        val rank2Okuden = item.first().rank2
        val rank3Okuden = item.first().rank3

        /**fetch views and display db items in it + set view to GONE if db item is empty*/
        val name: TextView = view.findViewById(R.id.okudenName)
        name.text = nameOkuden
        val prerequisite: TextView = view.findViewById(R.id.prerequesite)
        prerequisite.text = "Prerequisite : " + prerequisiteOkuden
        val rank1: TextView = view.findViewById(R.id.okudenRank1)
        rank1.text = rank1Okuden
        val rank2: TextView = view.findViewById(R.id.okudenRank2)
        rank2.text = rank2Okuden
        val rank3: TextView = view.findViewById(R.id.okudenRank3)
        rank3.text = rank3Okuden
    }

    private fun getOkuden(uid: Int): List<Okuden>{
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getOkudenById(uid = uid)
    }
}