package com.photon.repository

import com.photon.network.FeedService

class FeedRepository(private val feedService: FeedService) {

    fun getFeed(user: String) = feedService.getFeed(user)

}