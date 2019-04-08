package com.ramadan.photon.network

import com.ramadan.photon.common.USER
import com.ramadan.photon.data.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedService {
    @GET("raw/{user}")
    fun getFeed(@Path(USER) user: String): Observable<List<Response>>
}