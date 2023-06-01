package com.rpg.l5rcompanion

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.rpg.l5rcompanion.database.MyDatabase
import com.rpg.l5rcompanion.database.Rules
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

        /**display or hide buttons (display only for stations)*/
        val ambassadorBtn : Button = view.findViewById(R.id.ambassadorStation)
        val governorBtn : Button = view.findViewById(R.id.governorStation)
        val keeperBtn : Button = view.findViewById(R.id.keeperTempleStation)
        val senseiBtn : Button = view.findViewById(R.id.masterSenseiStation)
        val merchantBtn : Button = view.findViewById(R.id.merchantPatronStation)
        val warlordBtn : Button = view.findViewById(R.id.warlordStation)
        if(nameRule != "Stations"){
            ambassadorBtn.visibility = View.GONE
            governorBtn.visibility = View.GONE
            keeperBtn.visibility = View.GONE
            senseiBtn.visibility = View.GONE
            merchantBtn.visibility = View.GONE
            warlordBtn.visibility = View.GONE
        }


        binding.ambassadorStation.setOnClickListener{
            view.findNavController().navigate(DetailRulesFragmentDirections.actionDetailRulesFragmentToDetailStationsFragment(1))
        }
        binding.governorStation.setOnClickListener{
            view.findNavController().navigate(DetailRulesFragmentDirections.actionDetailRulesFragmentToDetailStationsFragment(2))
        }
        binding.keeperTempleStation.setOnClickListener{
            view.findNavController().navigate(DetailRulesFragmentDirections.actionDetailRulesFragmentToDetailStationsFragment(3))
        }
        binding.masterSenseiStation.setOnClickListener{
            view.findNavController().navigate(DetailRulesFragmentDirections.actionDetailRulesFragmentToDetailStationsFragment(4))
        }
        binding.merchantPatronStation.setOnClickListener{
            view.findNavController().navigate(DetailRulesFragmentDirections.actionDetailRulesFragmentToDetailStationsFragment(5))
        }
        binding.warlordStation.setOnClickListener{
            view.findNavController().navigate(DetailRulesFragmentDirections.actionDetailRulesFragmentToDetailStationsFragment(6))
        }
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