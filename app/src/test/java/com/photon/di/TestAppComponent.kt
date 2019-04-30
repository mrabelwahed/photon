package com.photon.di

import com.photon.base.BaseTest
import com.photon.domain.FeedUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,RepositoryModule::class,ViewModelModule::class,FeedUseCaseModule::class])
interface TestAppComponent {
    fun inject(baseTest: BaseTest)
}