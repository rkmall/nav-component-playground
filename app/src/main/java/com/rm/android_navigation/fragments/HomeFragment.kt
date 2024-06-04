package com.rm.android_navigation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.rm.android_navigation.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()

        binding.btnToFragA.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAFragment())
        }

        binding.btnToFragB.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToBFragment("Nokia"))
        }

        getBackStackInfo()

        viewLifecycleOwner.lifecycleScope.launch {
            findNavController().currentBackStack.flowWithLifecycle(
                viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED
            ).collectLatest { entryList ->
                val list = entryList.joinToString(separator = "\n") {
                    buildString {
                        append(it.destination.label)
                    }
                }
                binding.txtBackStackList.movementMethod = ScrollingMovementMethod()
                binding.txtBackStackList.text = list
            }
        }
    }

    private fun getBackStackInfo() {
        val fragmentManager = parentFragmentManager
        val backStackEntryCount = fragmentManager.backStackEntryCount
        binding.txtBackStackCount.text = backStackEntryCount.toString()

        val currentBackStackEntryLabel = findNavController().currentBackStackEntry?.destination?.label
        binding.currentBackStack.text = currentBackStackEntryLabel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}