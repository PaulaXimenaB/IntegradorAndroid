package com.example.integradorandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.integradorandroid.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment(R.layout.fragment_category) {
   lateinit var binding: FragmentCategoryBinding
   val args by navArgs<CategoryFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)

        binding.btnEducation.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Education"
            )
            findNavController().navigate(action)
        }
        binding.btnRecreational.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Recreational"
            )
            findNavController().navigate(action)
        }
        binding.btnSocial.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Social"
            )
            findNavController().navigate(action)
        }
        binding.btnDiy.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Diy"
            )
            findNavController().navigate(action)
        }
        binding.btnCharity.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Charity"
            )
            findNavController().navigate(action)
        }
        binding.btnCooking.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Cooking"
            )
            findNavController().navigate(action)
        }
        binding.btnRelaxation.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Relaxation"
            )
            findNavController().navigate(action)
        }
        binding.btnMusic.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Music"
            )
            findNavController().navigate(action)
        }
        binding.btnBusywork.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
                args.participants, "Busywork"
            )
            findNavController().navigate(action)
        }

        binding.btnRandom.setOnClickListener {
            val action = CategoryFragmentDirections.actionCategoryFragmentToPastimeFragment(
            args.participants, "Random"
            )
            findNavController().navigate(action)
        }
    }
}