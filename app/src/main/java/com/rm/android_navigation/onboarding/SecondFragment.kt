package com.rm.android_navigation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.rm.android_navigation.R
import com.rm.android_navigation.databinding.FragmentSecondBinding
import com.rm.android_navigation.utils.hideToolBar


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideToolBar(requireActivity() as AppCompatActivity)
        setThirdOnboardingFragment()
    }

    private fun setThirdOnboardingFragment() {
        val onBoardingViewPager = activity?.findViewById<ViewPager2>(R.id.on_boarding_view_pager)
        binding.onboardSecondBtn.setOnClickListener { onBoardingViewPager?.currentItem = 2 }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}