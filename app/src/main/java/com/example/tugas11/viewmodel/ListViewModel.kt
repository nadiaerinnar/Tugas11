package com.example.tugas11.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tugas11.api.CommentService
import com.example.tugas11.model.Comment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel() {
    private val photosService = CommentService()
    private val disposable = CompositeDisposable()
    val photos = MutableLiveData<List<Comment>>()

    fun fetchData() {
        disposable.add(
            photosService.getPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableSingleObserver<List<Comment>>() {
                    override fun onSuccess(value: List<Comment>?) {
                        photos.value = value
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("ERRORFETCHDATA", "error$e")
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}