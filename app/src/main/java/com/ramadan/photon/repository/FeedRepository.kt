package com.ramadan.photon.repository

import com.ramadan.photon.network.FeedService

class FeedRepository (private val feedService: FeedService){

    fun getFeed(user: String) = feedService.getFeed(user)

}