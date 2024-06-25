package com.example.apphub.mvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apphub.mvvm.repository.AuthRepository
import com.example.apphub.mvvm.viewmodels.AuthViewModel

class AuthViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AuthViewModel::class.java)){
            return AuthViewModel(authRepository = AuthRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}