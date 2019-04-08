package com.ramadan.photon.di

import com.ramadan.photon.common.OBSERVER_ON
import com.ramadan.photon.common.SUBCRIBER_ON
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class RxModule {

    @Provides
    @Named(SUBCRIBER_ON)
    fun provideSubscriberOn() = Schedulers.io()

    @Provides
    @Named(OBSERVER_ON)
    fun providesObserverOn() = AndroidSchedulers.mainThread()


}