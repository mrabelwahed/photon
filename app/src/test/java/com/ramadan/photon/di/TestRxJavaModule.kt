package com.ramadan.photon.di

import com.ramadan.photon.common.OBSERVER_ON
import com.ramadan.photon.common.SUBCRIBER_ON
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class TestRxJavaModule {
    @Provides
    @Named(SUBCRIBER_ON)
    fun provideSubscriberOn() = Schedulers.trampoline()

    @Provides
    @Named(OBSERVER_ON)
    fun providesObserverOn() =  Schedulers.trampoline()
}