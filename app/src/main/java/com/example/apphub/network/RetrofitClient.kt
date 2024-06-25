package com.example.apphub.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL="http://192.168.1.56:3000/"

    private val interceptor= HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient=OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val instance:Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

    val apiService:ApiService by lazy {
        instance.create(ApiService::class.java)
    }
}