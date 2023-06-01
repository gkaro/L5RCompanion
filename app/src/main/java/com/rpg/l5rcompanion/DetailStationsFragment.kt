package com.rpg.l5rcompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.database.Stations

class DetailStationsFragment : Fragment() {

    private val args: DetailStationsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_detail_stations, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val uid = args.uid
        val item = getStation(uid)
        val nameStation = item.first().name
        val contentStation = item.first().content

        val name: TextView = view.findViewById(R.id.stationName)
        name.text = nameStation
        val content: TextView = view.findViewById(R.id.stationContent)
        content.text = contentStation
    }

    private fun getStation(uid: Int): List<Stations> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getStationById(uid = uid)
    }
}