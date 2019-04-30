package com.photon.network

import com.photon.common.USER
import com.photon.data.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedService {
    @GET("raw/{user}")
    fun getFeed(@Path(USER) user: String): Observable<List<Response>>
}