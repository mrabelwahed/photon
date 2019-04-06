package com.ramadan.photon.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ramadan.photon.data.FeedMapper
import com.ramadan.photon.model.Feed
import com.ramadan.photon.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FeedViewModel :ViewModel(){

val compositeDisposable = CompositeDisposable()
    val feedMutableLiveData = MutableLiveData<List<Feed>>()


    fun getFeed(username:String){
        if (feedMutableLiveData.value !=null){
            return
        }
        val dispossable = ApiClient.getFeedSerivce()
            .getFeed(username)
            .map { data -> FeedMapper.transform(data) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                feedMutableLiveData.value = it
            }
        compositeDisposable.add(dispossable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getLiveData() : LiveData<List<Feed>> = feedMutableLiveData

}