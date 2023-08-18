package com.example.myapplication.domain

import PostRepository
import com.example.myapplication.models.Post

class GetPostsUseCase(private val repository: PostRepository) {
//    suspend operator fun invoke(): List<Post> {
//        return repository.getPosts()
//    }
}
