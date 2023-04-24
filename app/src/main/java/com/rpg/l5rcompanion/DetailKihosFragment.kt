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
import com.rpg.l5rcompanion.database.Kihos
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.databinding.FragmentDetailKihosBinding

class DetailKihosFragment : Fragment() {

    private val args: DetailKihosFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailKihosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailKihosBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**list of items from database */
        val uid = args.uid
        val item = getKihos(uid)
        val nameKiho = item.first().name
        val ringKiho = item.first().ring
        val masteryKiho = item.first().mastery
        val typeKiho = item.first().type
        val descriptionKiho = item.first().description


        /**fetch views and display db items in it + set view to GONE if db item is empty*/
        val name: TextView = view.findViewById(R.id.kihoName)
        name.text = nameKiho
        val ring: TextView = view.findViewById(R.id.ring)
        ring.text = "Ring : $ringKiho"
        val mastery: TextView = view.findViewById(R.id.mastery)
        mastery.text = "Mastery : $masteryKiho"
        val type: TextView = view.findViewById(R.id.type)
        type.text = "Schools : $typeKiho"

        val description: TextView = view.findViewById(R.id.description)
        description.text = descriptionKiho

    }

    private fun getKihos(uid: Int): List<Kihos> {
        val db = Room.databaseBuilder(
            activity as AppCompatActivity,
            MyDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
        return db.l5rCompanionDao().getKihosById(uid = uid)
    }

}