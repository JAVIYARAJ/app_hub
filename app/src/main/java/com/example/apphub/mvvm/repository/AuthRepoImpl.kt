package com.example.apphub.mvvm.repository

import com.example.apphub.mvvm.model.common.ApiResult
import com.example.apphub.network.RetrofitClient
import com.google.gson.JsonObject

interface AuthRepoImpl {
    suspend fun login(email:String,password:String):ApiResult<JsonObject>
}

class  AuthRepository:AuthRepoImpl{
    override suspend fun login(email: String, password: String): ApiResult<JsonObject> {
        try{
            val payLoad=JsonObject()
            payLoad.addProperty("email",email)
            payLoad.addProperty("password",password)

            val response=RetrofitClient.apiService.loginUser(payLoad)
            return if(response.isSuccessful){
                response.body().let {
                    ApiResult.Success(response.body()!!)
                }
            }else{
                ApiResult.Error(response.message())
            }
        }catch (error:Exception){
            return ApiResult.Error(error.message.toString())
        }
    }

}