package com.ramadan.photon.di

import android.app.Application
import com.ramadan.photon.common.BASE_URL

open class BaseApplication : Application() {
    lateinit var appComponent: BaseComponent
    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    protected  open fun initDagger() = DaggerBaseComponent.builder()
            .networkModule(NetworkModule(BASE_URL))
            .repositoryModule(RepositoryModule())
            .build()

}