package com.example.integradorandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.integradorandroid.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment(R.layout.fragment_category) {
   lateinit var binding: FragmentCategoryBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCategoryBinding.bind(view)
    }
}