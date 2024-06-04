package com.rm.android_navigation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rm.android_navigation.databinding.FragmentOnboardingAdapterBinding


class OnboardingAdapterFragment : Fragment() {

    private var _binding: FragmentOnboardingAdapterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingAdapterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpOnboardingViewPager()
    }

    private fun setUpOnboardingViewPager() {
        val onBoardingFragments = arrayListOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )

        val fragmentsViewPager = OnBoardingAdapter(
            onBoardingFragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.onBoardingViewPager.adapter = fragmentsViewPager
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}