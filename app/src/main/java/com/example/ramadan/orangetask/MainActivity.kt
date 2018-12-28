package com.example.ramadan.orangetask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ramadan.imageloadinglib.core.ImageLoader
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ImageLoader.getInstance(applicationContext).displayImage("https://picsum.photos/200/300", myimage)
        ImageLoader.getInstance(applicationContext).displayImage("http://mahmoudramadan.net/wp-content/uploads/2018/10/my-image.jpg", myimage1)
        ImageLoader.getInstance(applicationContext).displayImage("https://media.licdn.com/dms/image/C4E03AQEeCVKaWK72xQ/profile-displayphoto-shrink_200_200/0?e=1548892800&v=beta&t=E5eoanENr1Thbjle90kP0QIuDcaKC9ywWwIRKm7pNZU", myimage2)
        ImageLoader.getInstance(applicationContext).displayImage("https://avatars0.githubusercontent.com/u/2456891?s=400&v=4", myimage3)

    }
}
