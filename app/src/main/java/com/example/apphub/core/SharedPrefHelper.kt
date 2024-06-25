package com.example.apphub.core

import android.content.Context
import android.content.SharedPreferences

object SharedPrefHelper {

    private const val preferenceName: String = "app_hub"
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
    
    fun setString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun setBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
}