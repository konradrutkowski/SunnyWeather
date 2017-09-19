package com.pjkr.sunnyweather.welcome

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.pjkr.sunnyweather.R
import com.squareup.picasso.Picasso

/**
 * Created by root on 19.09.2017.
 */

class NoLocationsFragment: Fragment() {

    private lateinit var gpsLocation: Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.welcome_screen_layout, container, false)
        val welcomePicture = view?.findViewById(R.id.welcome_picture) as ImageView
        gpsLocation = view.findViewById(R.id.button_auto) as Button
        Picasso.with(activity).load(R.drawable.sun_512x512).fit().centerCrop().into(welcomePicture)
       // gpsLocation.setOnClickListener({ addDynamicPosition() })
        return view
    }
}
