package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rpg.l5rcompanion.databinding.FragmentListArmorsWeaponsBinding

class ListArmorsWeaponsFragment : Fragment() {

    private lateinit var binding: FragmentListArmorsWeaponsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListArmorsWeaponsBinding.inflate(layoutInflater)
        binding.armors.setOnClickListener {
            val uid = 1
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListArmorsFragment(uid))
        }
        binding.arrows.setOnClickListener {
            val uid = 2
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.bows.setOnClickListener {
            val uid = 3
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.chains.setOnClickListener {
            val uid = 4
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.firearms.setOnClickListener {
            val uid = 5
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.heavy.setOnClickListener {
            val uid = 6
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.knives.setOnClickListener {
            val uid = 7
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.ninjutsu.setOnClickListener {
            val uid = 8
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.polearms.setOnClickListener {
            val uid = 9
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.sling.setOnClickListener {
            val uid = 10
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.spears.setOnClickListener {
            val uid = 11
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.staves.setOnClickListener {
            val uid = 12
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.swords.setOnClickListener {
            val uid = 13
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        binding.warfans.setOnClickListener {
            val uid = 14
            findNavController().navigate(ListArmorsWeaponsFragmentDirections.actionListArmorsWeaponsFragmentToListWeaponsFragment(uid))
        }
        return binding.root
    }
}