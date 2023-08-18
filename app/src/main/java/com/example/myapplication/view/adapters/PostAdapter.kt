package com.example.myapplication.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemPostBinding
import com.example.myapplication.models.Post

class PostAdapter : RecyclerView.Adapter<PostViewHolder>() {
    private var posts: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
//        holder.bind(post)
    }
    override fun getItemCount(): Int = posts.size


    fun setPosts(posts: List<Post>) {
        this.posts = posts
        Log.d("TAG","checkInadapter:::${this.posts}::::before:::${posts}")
        notifyDataSetChanged()
    }
}



class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
//        binding.titleTextView.text = post.translation_id
//        binding.bodyTextView.text = post.translation_name

        binding.post = post
        binding.executePendingBindings()
    }
}

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.translation_id == newItem.translation_id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}
