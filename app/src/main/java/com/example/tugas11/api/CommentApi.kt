package com.example.tugas11.api

import com.example.tugas11.model.Comment
import io.reactivex.Single
import retrofit2.http.GET

interface CommentApi {
    @GET("posts")
    fun getPhotos(): Single<List<Comment>>

}