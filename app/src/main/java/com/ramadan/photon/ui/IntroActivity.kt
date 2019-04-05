package com.ramadan.photon.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.imageloadinglib.core.ImageLoader
import  com.ramadan.photon.R
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    companion object {
        val URL1 = "https://i.pinimg.com/originals/93/09/77/930977991c52b48e664c059990dea125.jpg"
    }

    private lateinit var imageLoader:ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        imageLoader = ImageLoader.getInstance(this)

        imageLoader.displayImage(URL1,image1,R.drawable.place_holder)


        listBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        clearBtn.setOnClickListener {
            imageLoader.clearcache()
        }



    }
}