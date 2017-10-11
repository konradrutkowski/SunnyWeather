package com.pjkr.sunnyweather.welcome.nolocation

import android.content.Context

/**
 * Created by Konrad Rutkowski on 11.10.2017.
 * This file is created for project SunnyWeather.
 */
class NoLocationContract {

    interface Presenter {
        fun addGPSLocation(context: Context)
    }

    interface View {
        fun startWeatherFragment(cityName: String)
        fun locationDataIsNotAvailable()
    }
}
