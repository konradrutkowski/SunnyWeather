package com.pjkr.sunnyweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import butterknife.BindView
import com.pjkr.sunnyweather.currentweather.fragment.CurrentWeatherFragment
import com.pjkr.sunnyweather.currentweather.model.Weather

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            var fragment: CurrentWeatherFragment = CurrentWeatherFragment()
            supportFragmentManager.beginTransaction().add(R.id.container, fragment, "").commit()
        }
    }
}
