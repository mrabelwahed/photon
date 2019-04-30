package com.photon.di

import com.photon.domain.FeedUseCase
import com.photon.repository.FeedRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FeedUseCaseModule {
    @Provides
    @Singleton
    fun provideFeedUseCase(feedRepo:FeedRepository) = FeedUseCase(feedRepo)
}