package com.example.integradorandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.integradorandroid.databinding.FragmentTermsBinding

class TermsFragment : Fragment(R.layout.fragment_terms) {

    lateinit var binding: FragmentTermsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTermsBinding.bind(view)
        binding.btnClose.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}