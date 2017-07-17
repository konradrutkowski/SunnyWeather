package com.pjkr.sunnyweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pjkr.sunnyweather.currentweather.fragment.CurrentWeatherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            var fragment: CurrentWeatherFragment = CurrentWeatherFragment()
            startFragment(R.id.container, fragment, "")
        }
    }
}
