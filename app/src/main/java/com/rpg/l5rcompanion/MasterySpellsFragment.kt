package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentMasterySpellsBinding

class MasterySpellsFragment : Fragment() {

    private val args: MasterySpellsFragmentArgs by this.navArgs()
    private lateinit var binding: FragmentMasterySpellsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val ring =args.ring
        binding = FragmentMasterySpellsBinding.inflate(layoutInflater)

        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        val btn1: TextView = binding.mastery1
        val itemList1 = db.l5rCompanionDao().getSpellsByMasteryandRing(1,ring)
        if(itemList1.isEmpty()){
            btn1.visibility = View.GONE
        }
        binding.mastery1.setOnClickListener {
            val uid = 1
            val itemList = db.l5rCompanionDao().getSpellsByMasteryandRing(uid,ring)
            if(itemList.isEmpty()){
               binding.mastery1.visibility = View.GONE
            }
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }

        val btn2: TextView = binding.mastery2
        val itemList2 = db.l5rCompanionDao().getSpellsByMasteryandRing(2,ring)
        if(itemList2.isEmpty()){
            btn2.visibility = View.GONE
        }
        binding.mastery2.setOnClickListener {
            val uid = 2
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }

        val btn3: TextView = binding.mastery3
        val itemList3 = db.l5rCompanionDao().getSpellsByMasteryandRing(3,ring)
        if(itemList3.isEmpty()){
            btn3.visibility = View.GONE
        }
        binding.mastery3.setOnClickListener {
            val uid = 3
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }

        val btn4: TextView = binding.mastery4
        val itemList4 = db.l5rCompanionDao().getSpellsByMasteryandRing(4,ring)
        if(itemList4.isEmpty()){
            btn4.visibility = View.GONE
        }
        binding.mastery4.setOnClickListener {
            val uid = 4
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }

        val btn5: TextView = binding.mastery5
        val itemList5 = db.l5rCompanionDao().getSpellsByMasteryandRing(5,ring)
        if(itemList5.isEmpty()){
            btn5.visibility = View.GONE
        }
        binding.mastery5.setOnClickListener {
            val uid = 5
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }

        val btn6: TextView = binding.mastery6
        val itemList6 = db.l5rCompanionDao().getSpellsByMasteryandRing(6,ring)
        if(itemList6.isEmpty()){
            btn6.visibility = View.GONE
        }
        binding.mastery6.setOnClickListener {
            val uid = 6
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }
        return binding.root
    }
}