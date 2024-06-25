package com.example.apphub.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    fun loginUser(@Body data:JsonObject):Response<JsonObject>

}