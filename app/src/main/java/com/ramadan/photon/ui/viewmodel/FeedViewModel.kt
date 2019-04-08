package com.ramadan.photon.ui.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ramadan.photon.common.OBSERVER_ON
import com.ramadan.photon.common.SUBCRIBER_ON
import com.ramadan.photon.data.FeedMapper
import com.ramadan.photon.model.Feed
import com.ramadan.photon.repository.FeedRepository
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class FeedViewModel @Inject constructor(
    private val feedRepository: FeedRepository,
    @param:Named(SUBCRIBER_ON) private val subscriberOn: Scheduler,
    @param:Named(OBSERVER_ON) private val observerOn: Scheduler
) : BaseViewModel() {

    val feedMutableLiveData = MutableLiveData<List<Feed>>()


    fun getFeed(username: String) {
        if (feedMutableLiveData.value != null) {
            return
        }
        val dispossable = feedRepository
            .getFeed(username)
            .map { data -> FeedMapper.transform(data) }
            .subscribeOn(subscriberOn)
            .observeOn(observerOn)
            .subscribe {
                feedMutableLiveData.value = it
            }
        compositeDisposable.add(dispossable)
    }


    fun getLiveData(): LiveData<List<Feed>> = feedMutableLiveData

}