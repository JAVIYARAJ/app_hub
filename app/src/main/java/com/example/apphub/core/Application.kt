package com.example.apphub.core

import android.app.Application

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPrefHelper.init(this)
    }
}