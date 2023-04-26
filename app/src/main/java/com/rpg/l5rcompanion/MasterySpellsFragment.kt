package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
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

        binding.mastery1.setOnClickListener {
            val uid = 1
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }
        binding.mastery2.setOnClickListener {
            val uid = 2
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }
        binding.mastery3.setOnClickListener {
            val uid = 3
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }
        binding.mastery4.setOnClickListener {
            val uid = 4
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
        }
        binding.mastery5.setOnClickListener {
            val uid = 5
            findNavController().navigate(MasterySpellsFragmentDirections.actionMasterySpellsFragmentToListSpellsFragment(
                ring, uid
            ))
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