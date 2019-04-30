package com.photon.di

import com.photon.network.FeedService
import com.photon.repository.FeedRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule  {
    @Provides
    @Singleton
    fun  provideFeedRepository( feedService: FeedService) = FeedRepository(feedService)
}