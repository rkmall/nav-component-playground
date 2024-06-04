package com.rm.android_navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rm.android_navigation.R
import com.rm.android_navigation.databinding.FragmentCBinding

class CFragment : Fragment() {

    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }
}