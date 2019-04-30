package com.photon.ui

import android.content.Intent
import com.imageloadinglib.core.Photon
import com.photon.common.CACHE_SIZE
import com.photon.common.URL1
import  com.photon.R
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : BaseActivity() {
    private lateinit var imageLoader:Photon

    override fun initUI() {
        imageLoader = Photon.getInstance(this , CACHE_SIZE) //4MiB
        imageLoader.displayImage(URL1,image1,R.drawable.place_holder)
        listBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        clearBtn.setOnClickListener {
            imageLoader.clearcache()
        }
    }

    override fun getLayoutById() = R.layout.activity_intro

}