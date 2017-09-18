package com.pjkr.sunnyweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by root on 18.09.2017.
 */

class WelcomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_screen_layout)
        val welcomePicture: ImageView = this.findViewById(R.id.welcome_picture) as ImageView
        Picasso.with(this).load(R.drawable.sun_512x512).fit().centerCrop().into(welcomePicture)
    }
}
