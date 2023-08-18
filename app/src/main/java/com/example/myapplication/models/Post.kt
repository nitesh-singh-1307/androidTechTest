package com.example.myapplication.models

//data class Post(val userName:String,val lastName:String)


data class Verse(
    val book_id: String,
    val book_name: String,
    val chapter: Int,
    val verse: Int,
    val text: String
)

data class Post(
    val reference: String,
    val verses: List<Verse>,
    val text: String,
    val translation_id: String,
    val translation_name: String,
    val translation_note: String
)
