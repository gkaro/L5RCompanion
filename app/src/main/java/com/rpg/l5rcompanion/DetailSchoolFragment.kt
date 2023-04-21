package com.rpg.l5rcompanion

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.R.id.schoolDescription
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.database.Schools
import com.rpg.l5rcompanion.databinding.FragmentDetailSchoolBinding


class DetailSchoolFragment : Fragment(R.layout.fragment_detail_school) {

    private val args: DetailSchoolFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailSchoolBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailSchoolBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        /**list of items from database */
        val uid = args.uid
        val item = getDetailsFromSchool(uid)
        val nameSchool = item.first().name
        val benefitSchool = item.first().benefit
        val disciplineSchool = item.first().discipline
        val skillsSchool = item.first().skills
        val descriptionSchool = item.first().description
        val honorSchool = item.first().honor
        val outfitSchool = item.first().outfit
        val titleRank1School = item.first().titleRank1
        val titleRank2School = item.first().titleRank2
        val titleRank3School = item.first().titleRank3
        val titleRank4School = item.first().titleRank4
        val titleRank5School = item.first().titleRank5
        val rank1School = item.first().rank1
        val rank2School = item.first().rank2
        val rank3School = item.first().rank3
        val rank4School = item.first().rank4
        val rank5School = item.first().rank5

        /**fetch views and display db items in it + set view to GONE if rank is empty*/
        val name: TextView = view.findViewById(R.id.schoolName)
        name.text = nameSchool
        val benefit: TextView = view.findViewById(R.id.schoolBenefit)
        benefit.text = "Benefit : $benefitSchool"
        val discipline: TextView = view.findViewById(R.id.schoolDiscipline)
        discipline.text = "Type : $disciplineSchool"
        val skills: TextView = view.findViewById(R.id.schoolSkills)
        skills.text = "Skills : $skillsSchool"
        val description: TextView = view.findViewById(schoolDescription)
        description.text = descriptionSchool
        val honor: TextView = view.findViewById(R.id.schoolHonor)
        honor.text = "Honor : $honorSchool"
        val outfit: TextView = view.findViewById(R.id.schoolOutfit)
        outfit.text = "Outfit : $outfitSchool"
        val titleRank1 = view.findViewById<TextView>(R.id.schoolTitleRank1)
        titleRank1.text = titleRank1School
        val titleRank2 = view.findViewById<TextView>(R.id.schoolTitleRank2)
        val mon2: ImageView = view.findViewById(R.id.mon2)
        titleRank2.text = titleRank2School
        if(titleRank2.length() == 0){
            titleRank2.visibility = View.GONE
            mon2.visibility = View.GONE
        }
        val titleRank3 = view.findViewById<TextView>(R.id.schoolTitleRank3)
        val mon3: ImageView = view.findViewById(R.id.mon3)
        titleRank3.text = titleRank3School
        if(titleRank3.length() == 0){
            titleRank3.visibility = View.GONE
            mon3.visibility = View.GONE
        }
        val titleRank4 = view.findViewById<TextView>(R.id.schoolTitleRank4)
        val mon4: ImageView = view.findViewById(R.id.mon4)
        titleRank4.text = titleRank4School
        if(titleRank4.length() == 0){
            titleRank4.visibility = View.GONE
            mon4.visibility = View.GONE
        }
        val titleRank5 = view.findViewById<TextView>(R.id.schoolTitleRank5)
        val mon5: ImageView = view.findViewById(R.id.mon5)
        titleRank5.text = titleRank5School
        if(titleRank5.length() == 0){
            titleRank5.visibility = View.GONE
            mon5.visibility = View.GONE
        }
        val rank1 = view.findViewById<TextView>(R.id.schoolRank1)
        rank1.text = rank1School
        val rank2 = view.findViewById<TextView>(R.id.schoolRank2)
        rank2.text = rank2School
        if(rank2.length() == 0){rank2.visibility = View.GONE}
        val rank3 = view.findViewById<TextView>(R.id.schoolRank3)
        rank3.text = rank3School
        if(rank3.length() == 0){rank3.visibility = View.GONE}
        val rank4 = view.findViewById<TextView>(R.id.schoolRank4)
        rank4.text = rank4School
        if(rank4.length() == 0){rank4.visibility = View.GONE}
        val rank5 = view.findViewById<TextView>(R.id.schoolRank5)
        rank5.text = rank5School
        if(rank5.length() == 0){rank5.visibility = View.GONE}

        /**display or hide description*/
        val seedesc :TextView = view.findViewById(schoolDescription)
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