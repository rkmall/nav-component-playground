package com.rm.android_navigation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.rm.android_navigation.R
import com.rm.android_navigation.databinding.FragmentFirstBinding
import com.rm.android_navigation.utils.hideToolBar

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideToolBar(requireActivity() as AppCompatActivity)
        setSecondOnboardingFragment()
    }

    private fun setSecondOnboardingFragment() {
        val onBoardingViewPager = activity?.findViewById<ViewPager2>(R.id.on_boarding_view_pager)
        binding.onboardFirstBtn.setOnClickListener { onBoardingViewPager?.currentItem = 1 }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}