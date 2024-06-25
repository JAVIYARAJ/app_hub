package com.example.apphub.ui.fragment.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.apphub.R
import com.example.apphub.databinding.FragmentCreatePasswordBinding

class CreatePasswordFragment : Fragment() {

    private lateinit var binding: FragmentCreatePasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentCreatePasswordBinding.inflate(inflater,container,false)
        init()
        clickEvent()
        return binding.root
    }

    private fun clickEvent() {
        binding.createPasswordBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.resetPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_global_loginFragment)
        }
    }
    
    private fun init() {

    }

}