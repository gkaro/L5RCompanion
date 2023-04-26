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
import com.rpg.l5rcompanion.database.Weapons
import com.rpg.l5rcompanion.databinding.FragmentDetailWeaponsBinding

class DetailWeaponsFragment : Fragment() {

    private val args: DetailWeaponsFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailWeaponsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailWeaponsBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val uid = args.uid
        val item = getDetailsFromWeapon(uid)
        val nameWeapon = item.first().name
        val typeWeapon = item.first().type
        val keywordsWeapon = item.first().keywords
        val drWeapon = item.first().dr
        val strengthWeapon = item.first().strength
        val rangeWeapon = item.first().range
        val priceWeapon = item.first().price
        val specialWeapon = item.first().special
        val descriptionWeapon = item.first().description

        val name: TextView = view.findViewById(R.id.weaponName)
        name.text = nameWeapon
        val type: TextView = view.findViewById(R.id.type)
        type.text = "Type :  $typeWeapon"
        val keywords: TextView = view.findViewById(R.id.keywords)
        keywords.text = "Keywords : $keywordsWeapon"
        if(keywords.length() == 0){
            keywords.visibility = View.GONE
        }
        val dr: TextView = view.findViewById(R.id.dr)
        dr.text = "Damage Rate : $drWeapon"
        if(dr.length() == 0){
            dr.visibility = View.GONE
        }
        val strength: TextView = view.findViewById(R.id.strength)
        strength.text = "Strength : $strengthWeapon"
        if(strength.length() == 0){
            strength.visibility = View.GONE
        }
        val range: TextView = view.findViewById(R.id.range)
        range.text = "Range : $rangeWeapon"
        if(range.length() == 0){
            range.visibility = View.GONE
        }
        val price: TextView = view.findViewById(R.id.price)
        price.text = "Price : $priceWeapon"
        val special: TextView = view.findViewById(R.id.special)
        special.text = specialWeapon
        if(special.length() == 0){
            special.visibility = View.GONE
        }
        val description: TextView = view.findViewById(R.id.description)
        description.text = descriptionWeapon
    }

    private fun getDetailsFromWeapon(uid: Int): List<Weapons> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getWeaponsById(uid = uid)
    }
}