package com.rm.android_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.rm.android_navigation.R
import com.rm.android_navigation.databinding.FragmentABinding

class AFragment : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNavigate.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        binding.btnPopBackStack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnPopBackStackInclusive.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, true)
        }

        binding.btnPopUpTo.setOnClickListener {
            findNavController().navigate(
                R.id.homeFragment,
                null,
                NavOptions.Builder()
                    .setPopUpTo(R.id.homeFragment, false)
                    .setLaunchSingleTop(true)
                    .build()
            )
        }

        binding.btnPopUpToInclusive.setOnClickListener {
            findNavController().navigate(
                R.id.homeFragment,
                null,
                NavOptions.Builder()
                    .setPopUpTo(R.id.homeFragment, true)
                    .build()
            )
        }

        binding.btnNavigateToB.setOnClickListener {
            findNavController().navigate(R.id.BFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
