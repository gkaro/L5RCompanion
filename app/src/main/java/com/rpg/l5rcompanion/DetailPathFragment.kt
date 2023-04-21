package com.rpg.l5rcompanion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.database.Paths
import com.rpg.l5rcompanion.databinding.FragmentDetailPathBinding

class DetailPathFragment : Fragment() {

    private val args: DetailPathFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailPathBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailPathBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**list of items from database */
        val uid = args.uid
        val item = getDetailsFromPath(uid)
        val nameSchool = item.first().name
        val replacesPath = item.first().replaces
        val ringsTraitsRequired = item.first().ringsTraitsRequirement
        val skillsRequired = item.first().skillsRequirement
        val otherRequired = item.first().otherRequirement
        val descriptionSchool = item.first().description
        val techniqueTitlePath = item.first().pathTechniqueTitle
        val techniquePath = item.first().pathTechnique
        val techniqueRank = item.first().techniqueRank

        /**fetch views and display db items in it + set view to GONE if db item is empty*/
        val name: TextView = view.findViewById(R.id.schoolName)
        name.text = nameSchool
        val replaces: TextView = view.findViewById(R.id.replaces)
        replaces.text = "Replaces : $replacesPath"
        if(replacesPath == ""){replaces.visibility = View.GONE}

        val ringsTraits: TextView = view.findViewById(R.id.schoolRingsRequired)
        ringsTraits.text = "Rings requirement : $ringsTraitsRequired"
        if(ringsTraitsRequired == ""){ringsTraits.visibility = View.GONE}

        val skillsReq: TextView = view.findViewById(R.id.schoolSkillsRequired)
        skillsReq.text = "Skills requirement : $skillsRequired"
        if(skillsRequired == ""){skillsReq.visibility = View.GONE}

        val otherReq: TextView = view.findViewById(R.id.schoolOtherRequired)
        otherReq.text = "Other requirement : $otherRequired"
        if(otherRequired == ""){otherReq.visibility = View.GONE}

        val description: TextView = view.findViewById(R.id.pathDescription)
        description.text = descriptionSchool
        val title: TextView = view.findViewById(R.id.pathTechniqueTitle)
        title.text = techniqueTitlePath
        val technique: TextView = view.findViewById(R.id.pathTechnique)
        technique.text = techniquePath

        /**change image according to rank*/
        val mon: ImageView = view.findViewById(R.id.mon1)
        if(techniqueRank == "2"){
            mon.setImageResource(R.drawable.minimon2)
        }
        if(techniqueRank == "3"){
            mon.setImageResource(R.drawable.minimon3)
        }
        if(techniqueRank == "4"){
            mon.setImageResource(R.drawable.minimon4)
        }
        if(techniqueRank == "5"){
            mon.setImageResource(R.drawable.minimon5)
        }

        /**display or hide description*/
        val seedesc :TextView = view.findViewById(R.id.pathDescription)
        seedesc.visibility = View.GONE
        val show: Button = view.findViewById(R.id.seemore)
        val hide: Button = view.findViewById(R.id.seeless)
        hide.visibility = View.GONE

        show.setOnClickListener {
            seedesc.visibility = View.VISIBLE
            hide.visibility = View.VISIBLE
            show.visibility = View.GONE
        }
        hide.setOnClickListener {
            seedesc.visibility = View.GONE
            hide.visibility = View.GONE
            show.visibility = View.VISIBLE
        }

    }

    private fun getDetailsFromPath(uid: Int): List<Paths> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getDetailsFromPath(uid = uid)
    }

}