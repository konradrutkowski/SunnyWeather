package com.pjkr.sunnyweather.currentweather.model

import com.google.gson.annotations.SerializedName
import com.pjkr.sunnyweather.longterm.model.City
import com.pjkr.sunnyweather.longterm.model.Properties
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

/**
 * Created by PJablonski on 28.06.2017.
 */
open class Weather: RealmObject() {
    var id: String? = null
    var main: String? = null
    var description: String? = null
    var icon: String? = null
    var coord: Coordinates? = null
    var base: String? = null
    var data: Data? = null
    var visibility: Int? = null
    var wind: Wind? = null

    @PrimaryKey
    @Required
    var name: String? = null
    var city: City? = null
    var cod: String? = null
    var message: Double? = null
    var cnt: Int? = null
    var list: RealmList<Properties>? = null
    var clouds: Clouds? = null

}