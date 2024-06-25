package com.example.apphub.mvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apphub.mvvm.model.common.ApiResult
import com.example.apphub.mvvm.repository.AuthRepository
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class AuthViewModel(private  val authRepository: AuthRepository):ViewModel() {

    private val _authStatus = MutableLiveData<JsonObject>()
    val authState:LiveData<JsonObject> = _authStatus

    private val _loadingState=MutableLiveData<Boolean>()
    val loadingState:LiveData<Boolean> = _loadingState

    private val _errorState=MutableLiveData<String>()
    val errorState:LiveData<String> = _errorState

    fun login(email:String,password:String){
        viewModelScope.launch {
            val response=authRepository.login(email,password)
            _loadingState.value=true
            when (response) {
                is ApiResult.Success -> {
                    _loadingState.value=false
                    _authStatus.value=response.data
                }

                is ApiResult.Error -> {
                    _loadingState.value=false
                    _errorState.value=response.message
                }

                else -> {
                    _loadingState.value=false
                }
            }
        }
    }

}