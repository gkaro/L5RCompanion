package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rpg.l5rcompanion.databinding.FragmentRingsSpellsBinding

class RingsSpellsFragment : Fragment() {

    private lateinit var binding: FragmentRingsSpellsBinding

            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
                binding = FragmentRingsSpellsBinding.inflate(layoutInflater)
                binding.airRing.setOnClickListener {
                    val ring = 1
                    findNavController().navigate(RingsSpellsFragmentDirections.actionRingsSpellsFragmentToMasterySpellsFragment(ring))
                }
                binding.earthRing.setOnClickListener {
                    val ring = 2
                    findNavController().navigate(RingsSpellsFragmentDirections.actionRingsSpellsFragmentToMasterySpellsFragment(ring))
                }
                binding.fireRing.setOnClickListener {
                    val ring = 3
                    findNavController().navigate(RingsSpellsFragmentDirections.actionRingsSpellsFragmentToMasterySpellsFragment(ring))
                }
                binding.waterRing.setOnClickListener {
                    val ring = 4
                    findNavController().navigate(RingsSpellsFragmentDirections.actionRingsSpellsFragmentToMasterySpellsFragment(ring))
                }
                binding.voidRing.setOnClickListener {
                    val ring = 5
                    findNavController().navigate(RingsSpellsFragmentDirections.actionRingsSpellsFragmentToMasterySpellsFragment(ring))
                }
                return binding.root
    }
}