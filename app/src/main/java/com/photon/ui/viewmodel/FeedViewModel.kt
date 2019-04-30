package com.photon.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.photon.data.FeedMapper
import com.photon.domain.FeedUseCase
import com.photon.model.Feed
import com.photon.repository.FeedRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FeedViewModel @Inject constructor(private val feedUseCase: FeedUseCase) : BaseViewModel() {

    val feedMutableLiveData = MutableLiveData<List<Feed>>()


    fun getFeed(username: String) {
        if (feedMutableLiveData.value != null) {
            return
        }
       val disposable = feedUseCase.getFeed(username)
            .subscribe {
                feedMutableLiveData.value = it
            }
        compositeDisposable.add(disposable)
    }


    fun getLiveData(): LiveData<List<Feed>> = feedMutableLiveData

}