package com.pjkr.sunnyweather.currentweather.model

import io.realm.RealmObject

/**
 * Created by PJablonski on 28.06.2017.
 */
open class Wind : RealmObject() {
    var speed: Float? = null
    var deg: Float? = null
}