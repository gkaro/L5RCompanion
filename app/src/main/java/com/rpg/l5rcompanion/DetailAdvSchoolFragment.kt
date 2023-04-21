package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.R.id.advSchoolDescription
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.database.Schools
import com.rpg.l5rcompanion.databinding.FragmentDetailAdvSchoolBinding
import org.json.JSONObject.NULL

class DetailAdvSchoolFragment : Fragment() {

    private val args: DetailAdvSchoolFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailAdvSchoolBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailAdvSchoolBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**list of items from database */
        val uid = args.uid
        val item = getDetailsFromSchool(uid)
        val nameSchool = item.first().name
        val ringsTraitsRequired = item.first().ringsTraitsRequirement
        val skillsRequired = item.first().skillsRequirement
        val otherRequired = item.first().otherRequirement
        val disciplineSchool = item.first().discipline
        val descriptionSchool = item.first().description
        val titleRank1School = item.first().titleRank1
        val titleRank2School = item.first().titleRank2
        val titleRank3School = item.first().titleRank3
        val rank1School = item.first().rank1
        val rank2School = item.first().rank2
        val rank3School = item.first().rank3

        /**fetch views and display db items in it + set view to GONE if db item is empty*/
        val name: TextView = view.findViewById(R.id.schoolName)
        name.text = nameSchool
        val ringsTraits: TextView = view.findViewById(R.id.schoolRingsRequired)
        ringsTraits.text = "Rings requirements : $ringsTraitsRequired"
        if(ringsTraitsRequired == ""){ringsTraits.visibility = View.GONE}

        val skillsReq: TextView = view.findViewById(R.id.schoolSkillsRequired)
        skillsReq.text = "Skills requirements : $skillsRequired"
        if(skillsRequired == ""){skillsReq.visibility = View.GONE}

        val otherReq: TextView = view.findViewById(R.id.schoolOtherRequired)
        otherReq.text = "Other requirements : $otherRequired"
        if(otherRequired == ""){otherReq.visibility = View.GONE}

        val discipline: TextView = view.findViewById(R.id.schoolDiscipline)
        discipline.text = "Type : $disciplineSchool"
        if(disciplineSchool == ""){discipline.visibility = View.GONE}

        val description: TextView = view.findViewById(advSchoolDescription)
        description.text = descriptionSchool
        val titleRank1 = view.findViewById<TextView>(R.id.schoolTitleRank1)
        titleRank1.text = titleRank1School
        val titleRank2 = view.findViewById<TextView>(R.id.schoolTitleRank2)
        titleRank2.text = titleRank2School
        val titleRank3 = view.findViewById<TextView>(R.id.schoolTitleRank3)
        titleRank3.text = titleRank3School
        val rank1 = view.findViewById<TextView>(R.id.schoolRank1)
        rank1.text = rank1School
        val rank2 = view.findViewById<TextView>(R.id.schoolRank2)
        rank2.text = rank2School
        val rank3 = view.findViewById<TextView>(R.id.schoolRank3)
        rank3.text = rank3School

        /**display or hide description*/
        val seedesc :TextView = view.findViewById(advSchoolDescription)
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

    private fun getDetailsFromSchool(uid: Int): List<Schools> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getDetailsFromSchool(uid = uid)
    }
}