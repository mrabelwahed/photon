package com.ramadan.photon.di

import com.ramadan.photon.base.BaseTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,RepositoryModule::class,ViewModelModule::class])
interface TestAppComponent {
    fun inject(baseTest: BaseTest)
}