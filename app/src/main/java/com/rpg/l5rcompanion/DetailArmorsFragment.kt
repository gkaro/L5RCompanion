package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.database.Armors
import com.rpg.l5rcompanion.database.Clans
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentDetailArmorsBinding
import com.rpg.l5rcompanion.databinding.FragmentDetailClanBinding

class DetailArmorsFragment : Fragment() {

    private val args: DetailArmorsFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailArmorsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailArmorsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val uid = args.uid
        val item = getDetailsFromArmor(uid)
        val nameArmor = item.first().name
        val tnArmor = item.first().armortn
        val reductionArmor = item.first().reduction
        val priceArmor = item.first().price
        val specialArmor = item.first().special
        val descriptionArmor = item.first().description

        val name: TextView = view.findViewById(R.id.armorName)
        name.text = nameArmor
        val armortn: TextView = view.findViewById(R.id.armortn)
        armortn.text = "Armor TN :  $tnArmor"
        val reduction: TextView = view.findViewById(R.id.reduction)
        reduction.text = "Reduction : $reductionArmor"
        val price: TextView = view.findViewById(R.id.price)
        price.text = "Price : $priceArmor"
        val special: TextView = view.findViewById(R.id.special)
        special.text = specialArmor
        val description: TextView = view.findViewById(R.id.description)
        description.text = descriptionArmor
    }

    private fun getDetailsFromArmor(uid: Int): List<Armors> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getArmorsById(uid = uid)
    }
}