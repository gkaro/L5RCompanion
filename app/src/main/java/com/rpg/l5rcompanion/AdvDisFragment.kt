package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rpg.l5rcompanion.databinding.FragmentAdvDisBinding

class AdvDisFragment : Fragment() {

    private lateinit var binding: FragmentAdvDisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdvDisBinding.inflate(layoutInflater)
        binding.advantages.setOnClickListener {
            val type = "advantage"
            findNavController().navigate(AdvDisFragmentDirections.actionAdvDisFragmentToListAdvdisFragment(type))
        }
        binding.disadvantages.setOnClickListener {
            val type = "disadvantage"
            findNavController().navigate(AdvDisFragmentDirections.actionAdvDisFragmentToListAdvdisFragment(type))
        }

        return binding.root
    }

}