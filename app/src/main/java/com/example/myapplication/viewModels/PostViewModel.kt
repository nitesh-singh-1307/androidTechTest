package com.example.myapplication.viewModels

import PostRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Post
import androidx.lifecycle.viewModelScope
import com.example.myapplication.uitils.RetrofitClient
import kotlinx.coroutines.launch


class PostViewModel(private val repository: PostRepository) : ViewModel() {

    private val _posts = MutableLiveData<Post>()
    val posts: LiveData<Post> = _posts


    fun fetchPosts(endPoint: String) {
        viewModelScope.launch {
            try{
                val result = repository.getPosts(endPoint)
                _posts.value = result
            }catch (e:Exception){
                Log.d("TAG","checkException::::::$e")
            }

        }
    }



}

