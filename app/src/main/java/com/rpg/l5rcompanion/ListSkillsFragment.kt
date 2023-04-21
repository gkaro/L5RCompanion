package com.rpg.l5rcompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rpg.l5rcompanion.databinding.FragmentListSchoolsBinding
import com.rpg.l5rcompanion.databinding.FragmentListSkillsBinding


class ListSkillsFragment : Fragment() {

    private lateinit var binding: FragmentListSkillsBinding
    private val args: ListSkillsFragmentArgs by this.navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListSkillsBinding.inflate(layoutInflater)
        binding.highSkills.setOnClickListener {
            val uid = 1
            findNavController().navigate(ListSkillsFragmentDirections.actionListSkillsFragmentToSkillsFragment(uid))
        }
        binding.bugeiSkills.setOnClickListener {
            val uid = 2
            findNavController().navigate(ListSkillsFragmentDirections.actionListSkillsFragmentToSkillsFragment(uid))
        }
        binding.merchantSkills.setOnClickListener {
            val uid = 3
            findNavController().navigate(ListSkillsFragmentDirections.actionListSkillsFragmentToSkillsFragment(uid))
        }
        binding.lowSkills.setOnClickListener {
            val uid = 4
            findNavController().navigate(ListSkillsFragmentDirections.actionListSkillsFragmentToSkillsFragment(uid))
        }
        return binding.root
    }
}