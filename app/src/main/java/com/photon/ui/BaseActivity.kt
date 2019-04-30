package com.photon.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.photon.di.BaseApplication
import com.photon.ui.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract  class BaseActivity : AppCompatActivity() {
   @Inject
    lateinit var viewModelFactory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        configureDagger()
        initUI()

    }
    // --- DEPENDENCIES INJECTION ---
    private fun configureDagger() = (this.application as BaseApplication).appComponent.inject(this)

    abstract  fun getLayoutById():Int
    abstract  fun initUI()
}