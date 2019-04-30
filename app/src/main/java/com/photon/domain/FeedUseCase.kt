package com.photon.domain

import com.photon.data.FeedMapper
import com.photon.model.Feed
import com.photon.repository.FeedRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FeedUseCase(private val feedRepository: FeedRepository) {

    fun getFeed(username: String): Observable<List<Feed>> {
        return feedRepository
            .getFeed(username)
            .map { data -> FeedMapper.transform(data) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}