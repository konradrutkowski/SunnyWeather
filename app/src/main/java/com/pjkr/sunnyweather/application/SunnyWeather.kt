package com.pjkr.sunnyweather.application

import android.app.Application
import io.realm.Realm

/**
 * Created by yabol on 09.09.2017.
 */
class SunnyWeather : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}