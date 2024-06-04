package com.rm.android_navigation.onboarding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rm.android_navigation.databinding.FragmentFirstBinding
import com.rm.android_navigation.databinding.FragmentThirdBinding
import com.rm.android_navigation.utils.hideToolBar


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideToolBar(requireActivity() as AppCompatActivity)
        setNavigation()
        saveOnboardingDone()
    }

    private fun setNavigation() {
        binding.onboardThirdBtn.setOnClickListener {
            findNavController().navigate(OnboardingAdapterFragmentDirections.actionOnboardingAdapterFragmentToHomeFragment())
        }
    }

    private fun saveOnboardingDone() {
        val sharedPreference = requireActivity().getSharedPreferences(SplashFragment.ONBOARDING, Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putBoolean(SplashFragment.FINISHED, true)
        editor.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
