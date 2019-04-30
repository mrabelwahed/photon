package com.photon.di

import com.photon.ui.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,FeedUseCaseModule::class, RepositoryModule::class, ViewModelModule::class])
interface BaseComponent {
    fun inject(baseActivity: BaseActivity)
}