package com.rm.android_navigation.onboarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.rm.android_navigation.R
import com.rm.android_navigation.databinding.FragmentFirstBinding
import com.rm.android_navigation.databinding.FragmentSplashBinding
import com.rm.android_navigation.utils.hideToolBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideToolBar(requireActivity() as AppCompatActivity)
        handleOnboarding()
    }

    private fun handleOnboarding() {
        viewLifecycleOwner.lifecycleScope.launch {
            delay(1500)
            if (isOnboardingDone()) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            } else {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToOnboardingAdapterFragment())
            }
        }
    }

    private fun isOnboardingDone(): Boolean {
        val sharedPreference = requireActivity().getSharedPreferences(ONBOARDING, Context.MODE_PRIVATE)
        return sharedPreference.getBoolean(FINISHED, false)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val FINISHED = "FINISHED"
        const val ONBOARDING = "ONBOARDING"
    }
}