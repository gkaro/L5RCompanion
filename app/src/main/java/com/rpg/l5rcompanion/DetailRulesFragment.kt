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
import com.rpg.l5rcompanion.database.Rules
import com.rpg.l5rcompanion.database.Schools
import com.rpg.l5rcompanion.databinding.FragmentDetailPathBinding
import com.rpg.l5rcompanion.databinding.FragmentDetailRulesBinding

class DetailRulesFragment : Fragment() {

    private val args: DetailRulesFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailRulesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailRulesBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**list of items from database */
        val uid = args.uid
        val item = getDetailsFromRule(uid)
        val nameRule = item.first().name
        val contentRule = item.first().content

        val name: TextView = view.findViewById(R.id.ruleName)
        name.text = nameRule
        val content: TextView = view.findViewById(R.id.content)
        content.text = contentRule
    }

    private fun getDetailsFromRule(uid: Int): List<Rules> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getRulesById(uid = uid)
    }
}