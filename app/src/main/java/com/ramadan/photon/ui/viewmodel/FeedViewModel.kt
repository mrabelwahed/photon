package com.ramadan.photon.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ramadan.photon.common.OBSERVER_ON
import com.ramadan.photon.common.SUBCRIBER_ON
import com.ramadan.photon.data.FeedMapper
import com.ramadan.photon.model.Feed
import com.ramadan.photon.repository.FeedRepository
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class FeedViewModel @Inject constructor(private val feedRepository: FeedRepository) : BaseViewModel() {

    val feedMutableLiveData = MutableLiveData<List<Feed>>()


    fun getFeed(username: String) {
        if (feedMutableLiveData.value != null) {
            return
        }
        val dispossable = feedRepository
            .getFeed(username)
            .map { data -> FeedMapper.transform(data) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                feedMutableLiveData.value = it
            }
        compositeDisposable.add(dispossable)
    }


    fun getLiveData(): LiveData<List<Feed>> = feedMutableLiveData

}