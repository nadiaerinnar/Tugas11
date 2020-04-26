package com.example.tugas11.model

import com.google.gson.annotations.SerializedName

data class Comment(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("body")
    val body:String?


)