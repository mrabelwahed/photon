package com.ramadan.photon.di

import com.ramadan.photon.network.FeedService
import com.ramadan.photon.repository.FeedRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule  {
    @Provides
    @Singleton
    fun  provideFeedRepository( feedService: FeedService) = FeedRepository(feedService)
}