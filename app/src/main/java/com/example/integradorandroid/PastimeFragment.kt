package com.example.integradorandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.integradorandroid.databinding.FragmentPastimeBinding

class PastimeFragment : Fragment(R.layout.fragment_pastime) {
    lateinit var binding: FragmentPastimeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPastimeBinding.bind(view)
    }
}