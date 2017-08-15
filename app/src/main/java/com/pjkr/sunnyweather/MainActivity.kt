package com.pjkr.sunnyweather

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.pjkr.sunnyweather.currentweather.fragment.CurrentWeatherFragment
import com.pjkr.sunnyweather.longterm.view.LongTermWeatherFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentWeather.setOnClickListener { startCurrentWeatherFragment() }
        forecast.setOnClickListener { startLongTermWeatherFragment() }

        if (savedInstanceState == null) {
            startCurrentWeatherFragment()
        }
    }

    private fun startCurrentWeatherFragment(){
        startFragment(R.id.container, CurrentWeatherFragment(), true, false, null)
    }

    private fun startLongTermWeatherFragment(){
        startFragment(R.id.container, LongTermWeatherFragment(), true, false, null)
    }


}
