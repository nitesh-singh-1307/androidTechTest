package com.example.myapplication.uitils

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initRetrofit()
    }

    private fun initRetrofit() {
        RetrofitClient.init(this)
    }
}
