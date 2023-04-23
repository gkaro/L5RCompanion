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
import com.rpg.l5rcompanion.database.Katas
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentDetailKatasBinding


class DetailKatasFragment : Fragment() {

    private val args: DetailKatasFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailKatasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailKatasBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**list of items from database */
        val uid = args.uid
        val item = getKatas(uid)
        val nameKata = item.first().name
        val ringKata = item.first().ring
        val masteryKata = item.first().mastery
        val schoolKata = item.first().schools
        val descriptionKata = item.first().description


        /**fetch views and display db items in it + set view to GONE if db item is empty*/
        val name: TextView = view.findViewById(R.id.kataName)
        name.text = nameKata
        val ring: TextView = view.findViewById(R.id.ring)
        ring.text = "Ring : $ringKata"
        val mastery: TextView = view.findViewById(R.id.mastery)
        mastery.text = "Mastery : $masteryKata"
        val schools: TextView = view.findViewById(R.id.schools)
        schools.text = "Schools : $schoolKata"

        val description: TextView = view.findViewById(R.id.description)
        description.text = descriptionKata

    }

    private fun getKatas(uid: Int): List<Katas> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getKatasById(uid = uid)
    }

}