package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.adapter.AdvdisAdapter
import com.rpg.l5rcompanion.database.AdvDis
import com.rpg.l5rcompanion.database.Armors
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentDetailAdvdisBinding

class DetailAdvdisFragment : Fragment() {

    private lateinit var binding: FragmentDetailAdvdisBinding
    private val args: DetailAdvdisFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailAdvdisBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val uid = args.uid
        val item = getDetailsFromAdv(uid)
        val nameAdv = item.first().name
        val subtypeAdv = item.first().subtype
        val pointsAdv = item.first().points
        val descriptionAdv = item.first().description

        val name: TextView = view.findViewById(R.id.advName)
        name.text = nameAdv
        val subtype: TextView = view.findViewById(R.id.subtype)
        subtype.text = subtypeAdv
        val points: TextView = view.findViewById(R.id.points)
        points.text = pointsAdv
        val description: TextView = view.findViewById(R.id.description)
        description.text = descriptionAdv
    }

    private fun getDetailsFromAdv(uid: Int): List<AdvDis> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getAdvDisById(uid = uid)
    }
}