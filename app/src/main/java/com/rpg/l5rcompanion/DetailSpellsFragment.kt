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
import com.rpg.l5rcompanion.database.Spells
import com.rpg.l5rcompanion.databinding.FragmentDetailSpellsBinding

class DetailSpellsFragment : Fragment() {

    private val args: DetailSpellsFragmentArgs by this.navArgs()
    private lateinit var binding: FragmentDetailSpellsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailSpellsBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        /**list of items from database */
        val uid = args.uid
        val item = getDetailsFromSpell(uid)
        val nameSpell = item.first().name
        val ringSpell = item.first().ring
        val typeSpell = item.first().type
        val areaSpell = item.first().area
        val contentSpell = item.first().content
        val rangeSpell = item.first().range
        val masterySpell = item.first().mastery
        val durationSpell = item.first().duration
        val raisesSpell = item.first().raises

        /**fetch views and display db items in it + set view to GONE if rank is empty*/
        val name: TextView = view.findViewById(R.id.spellName)
        name.text = nameSpell
        val ring: TextView = view.findViewById(R.id.ring)
        val ringtext = view.findViewById<TextView>(R.id.ring)
        if(ringSpell== "0"){
            ringtext.visibility = View.GONE
        }
        if(ringSpell== "1"){
            ring.text = "Air Ring / Mastery Level $masterySpell"
        }
        if(ringSpell== "2"){
            ring.text = "Earth Ring / Mastery Level $masterySpell"
        }
        if(ringSpell== "3"){
            ring.text = "Fire Ring / Mastery Level $masterySpell"
        }
        if(ringSpell== "4"){
            ring.text = "Water Ring / Mastery Level $masterySpell"
        }
        if(ringSpell== "5"){
            ring.text = "Void Ring / Mastery Level $masterySpell"
        }
        val type: TextView = view.findViewById(R.id.type)
        type.text = "Type : $typeSpell"
        if(typeSpell.isEmpty()){type.visibility = View.GONE}
        val area: TextView = view.findViewById(R.id.area)
        area.text = "Area : $areaSpell"
        val content: TextView = view.findViewById(R.id.content)
        content.text = contentSpell
        val range: TextView = view.findViewById(R.id.range)
        range.text = "Range : $rangeSpell"
        val duration: TextView = view.findViewById(R.id.duration)
        duration.text = "Duration : $durationSpell"
        val raises: TextView = view.findViewById(R.id.raises)
        raises.text = "Raises : $raisesSpell"
    }

    private fun getDetailsFromSpell(uid: Int): List<Spells> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getSpellsById(uid = uid)
    }
}