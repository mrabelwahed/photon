package com.ramadan.photon.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ramadan.photon.ui.viewmodel.FeedViewModel
import com.ramadan.photon.ui.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    internal abstract fun postMainViewModel(viewModel: FeedViewModel): ViewModel

}