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
import com.rpg.l5rcompanion.database.Skills
import com.rpg.l5rcompanion.databinding.FragmentDetailSkillsBinding


class DetailSkillsFragment : Fragment(R.layout.fragment_detail_skills) {

    private val args: DetailSkillsFragmentArgs by this.navArgs()
    private lateinit var binding: FragmentDetailSkillsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailSkillsBinding.inflate(layoutInflater)
        return binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        /**list of items from database */
        val uid = args.uid
        val item = getDetailsFromSkill(uid)
        val nameSkill = item.first().name
        val catSkill = item.first().category
        val typeSkill = item.first().type
        val traitSkill = item.first().trait
        val contentSkill = item.first().content
        val emphaseSkill = item.first().emphases
        val masterySkill = item.first().mastery



        /**fetch views and display db items in it + set view to GONE if rank is empty*/
        val name: TextView = view.findViewById(R.id.skillName)
        name.text = "$nameSkill [$traitSkill]"
        val category: TextView = view.findViewById(R.id.category)
        if(catSkill == "1"){category.text = "High Skill"}
        if(catSkill == "2"){category.text = "Bugei Skill"}
        if(catSkill == "3"){category.text = "Merchant Skill"}
        if(catSkill == "4"){category.text = "Low Skill"}

        val type: TextView = view.findViewById(R.id.type)
        type.text = "Type : $typeSkill"
        if(typeSkill.isEmpty()){
            type.visibility = View.GONE
        }
        val content: TextView = view.findViewById(R.id.content)
        content.text = contentSkill
        val emphases: TextView = view.findViewById(R.id.emphase)
        emphases.text = "Emphases : $emphaseSkill"
        if(emphaseSkill.isEmpty()){
            emphases.visibility = View.GONE
        }
        val mastery: TextView = view.findViewById(R.id.mastery)
        mastery.text = masterySkill

    }

    private fun getDetailsFromSkill(uid: Int): List<Skills> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getSkillsById(uid = uid)
    }
}