package com.example.apphub.ui.fragment.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apphub.R
import com.example.apphub.core.SharedPrefHelper
import com.example.apphub.databinding.FragmentLoginBinding
import com.example.apphub.mvvm.factory.AuthViewModelFactory
import com.example.apphub.mvvm.viewmodels.AuthViewModel
import com.example.apphub.network.RetrofitClient
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLoginBinding.inflate(inflater,container,false)
        init()
        clickEvent()
        observer()
        return binding.root
    }

    private fun observer() {
        authViewModel.authState.observe(viewLifecycleOwner){
            Log.d("TAG", "observer: response ${it}")

        }

        authViewModel.loadingState.observe(viewLifecycleOwner){

        }

        authViewModel.errorState.observe(viewLifecycleOwner){
            Log.d("TAG", "observer: error ${it}")
        }
    }

    private fun init() {

        authViewModel=ViewModelProvider(this,AuthViewModelFactory())[AuthViewModel::class.java]

        val email=SharedPrefHelper.getString("email")
        email?.let {
            binding.emailTI.setText(it)
        }
        val password=SharedPrefHelper.getString("password")
        password?.let {
            binding.passwordTI.setText(it)
        }
        if(email!=null && password!=null){
            binding.rememberCheckbox.isChecked=true
        }
    }

    private fun clickEvent() {
        binding.forgotTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        binding.registerLabelTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.loginBtn.setOnClickListener {
            if(binding.emailTI.text.toString().isNotEmpty() && binding.passwordTI.text.toString().isNotEmpty() && binding.rememberCheckbox.isChecked){
                SharedPrefHelper.setString("email",binding.emailTI.text.toString())
                SharedPrefHelper.setString("password",binding.passwordTI.text.toString())
                authViewModel.login(email = binding.emailTI.text?.trim().toString(), password = binding.passwordTI.text?.trim().toString())
            }
        }

    }

}