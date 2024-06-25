package com.example.apphub.ui.fragment.auth

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.example.apphub.R
import com.example.apphub.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentForgotPasswordBinding.inflate(inflater,container,false)
        init()
        clickEvent()
        return binding.root
    }

    private fun init() {
        binding.emailTI.doAfterTextChanged {
            if(Patterns.EMAIL_ADDRESS.matcher(it.toString()).matches()){
                binding.resetPasswordButton.alpha=1f
            }else{
                binding.resetPasswordButton.alpha=0.6f
            }
        }
    }

    private fun clickEvent() {
        binding.forgotBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.resetPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_verificationFragment)
        }

    }

}