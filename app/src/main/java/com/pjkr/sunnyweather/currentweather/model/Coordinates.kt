package com.pjkr.sunnyweather.currentweather.model

import io.realm.RealmObject

/**
 * Created by PJablonski on 28.06.2017.
 */
open class Coordinates : RealmObject(){
    var lon: Float = 0f
    var lat: Float = 0f
}