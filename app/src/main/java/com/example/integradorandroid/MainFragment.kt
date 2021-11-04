package com.example.integradorandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.integradorandroid.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
   lateinit var binding: FragmentMainBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding.btnStart.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToCategoryFragment(
                binding.etParticipants.text.toString().toInt()
            )
            findNavController().navigate(action)
        }
        binding.tvTerms.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_termsFragment)
        }

    }
}