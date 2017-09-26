package com.pjkr.sunnyweather

import android.app.Application
import io.realm.Realm

/**
 * Created by Konrad Rutkowski on 26.09.2017.
 */
class SunnyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }

}