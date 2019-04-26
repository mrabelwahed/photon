package com.ramadan.photon.di

import com.ramadan.photon.ui.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
interface BaseComponent {
    fun inject(baseActivity: BaseActivity)
}