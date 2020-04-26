package com.example.tugas11.api

import com.example.tugas11.model.Comment
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CommentService {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val api: CommentApi

    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CommentApi::class.java)
    }

    fun getPhotos(): Single<List<Comment>> {
        return api.getPhotos()
    }
}