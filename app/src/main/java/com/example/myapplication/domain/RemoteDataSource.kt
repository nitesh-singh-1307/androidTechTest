package com.example.myapplication.domain

import com.example.myapplication.apiService.ApiService
import com.example.myapplication.models.Post
import retrofit2.Response

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getPosts(userId: String): Post {
        return apiService.getPosts(userId)
    }
}