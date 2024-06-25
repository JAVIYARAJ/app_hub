package com.example.apphub.ui.fragment.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.apphub.R
import com.example.apphub.core.SharedPrefHelper
import com.example.apphub.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private lateinit var binding:FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentWelcomeBinding.inflate(inflater,container,false)
        clickEvent()
        return binding.root
    }

    private fun clickEvent() {
        binding.getStartedIcon.setOnClickListener {
            SharedPrefHelper.setBoolean("isWelcome",true)
            findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
    }

}