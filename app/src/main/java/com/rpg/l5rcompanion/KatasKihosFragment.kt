package com.rpg.l5rcompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rpg.l5rcompanion.databinding.FragmentKatasKihosBinding

class KatasKihosFragment : Fragment() {

    private lateinit var binding: FragmentKatasKihosBinding

            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
                binding = FragmentKatasKihosBinding.inflate(layoutInflater)
               binding.katas.setOnClickListener {
                    findNavController().navigate(R.id.action_katasKihosFragment_to_listKatasFragment)
                }
                binding.kihos.setOnClickListener {
                    findNavController().navigate(R.id.action_katasKihosFragment_to_listKihosFragment)
                }
                return binding.root
    }

}