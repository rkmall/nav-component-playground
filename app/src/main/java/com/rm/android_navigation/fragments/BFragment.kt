package com.rm.android_navigation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.rm.android_navigation.R
import com.rm.android_navigation.databinding.FragmentBBinding
import com.rm.android_navigation.databinding.FragmentFirstBinding


class BFragment : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPopBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnPopUpToHomeInclusive.setOnClickListener {
            findNavController().navigate(
                BFragmentDirections.actionBFragmentToHomeFragment(),
                NavOptions.Builder().setPopUpTo(R.id.homeFragment, true).build()
            )
        }

        binding.btnClearBackStack.setOnClickListener {
            findNavController().run {
                navigate(
                    R.id.homeFragment,
                    null,
                    NavOptions.Builder().setPopUpTo(graph.startDestinationId, true).build()
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}