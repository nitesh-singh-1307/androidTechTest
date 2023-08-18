package com.example.myapplication.apiService

import com.example.myapplication.models.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getPosts(@Url endpoint: String): Post
}



