package com.rpg.l5rcompanion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.rpg.l5rcompanion.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)

        binding.version.text = "version " + BuildConfig.VERSION_NAME

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        binding.schools.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_listClansFragment,null, options)
        }

        binding.rules.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_listRulesFragment,null, options)
        }

        binding.skills.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_listSkillsFragment,null, options)
        }

        binding.spells.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_ringsSpellsFragment,null, options)
        }

        binding.katas.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_katasKihosFragment,null, options)
        }

        binding.kihos.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_listOkudenFragment,null, options)
        }

        binding.armorsweapons.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_listArmorsWeaponsFragment,null, options)
        }

        binding.advDisadv.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_advDisFragment,null, options)
        }


        return binding.root
    }






}