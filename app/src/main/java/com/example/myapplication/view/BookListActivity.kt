package com.example.myapplication.view

import PostRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityBookListBinding
import com.example.myapplication.uitils.RetrofitClient
import com.example.myapplication.uitils.ViewModelFactory
import com.example.myapplication.view.adapters.PostAdapter
import com.example.myapplication.viewModels.PostViewModel


class BookListActivity : AppCompatActivity() {
    private lateinit var viewModel: PostViewModel

    private lateinit var binding : ActivityBookListBinding
    private val endPoint = "https://bible-api.com/john%203:16"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_list)

        val repository = PostRepository(RetrofitClient.apiService)
        val viewModelFactory = ViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)
        viewModel.fetchPosts(endPoint)


        binding.viewModel = viewModel
        val adapter = PostAdapter()
        binding.adapter = adapter

        viewModel.posts.observe(this, Observer {
//            adapter. = it
            adapter.setPosts(listOf(it))

            Log.d("TAG","checkIt:::::$it")
        })


    }
}