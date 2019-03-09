package com.ramadan.photon.data

import com.ramadan.photon.model.Feed

object FeedMapper {

    fun transform(response : Response): Feed {
        return Feed(response.user.name, response.likes, response.user.profileImage.large)
    }

    fun transform(responseCollection: Collection<Response>): List<Feed> {
        val feedList = mutableListOf<Feed>()
        for (feedResponse in responseCollection) {
            val feed = transform(feedResponse)
            if (feed != null) {
                feedList.add(feed)
            }
        }

        return feedList
    }
}