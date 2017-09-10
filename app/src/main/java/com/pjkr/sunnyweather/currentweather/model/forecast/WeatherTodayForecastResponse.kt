package com.pjkr.sunnyweather.currentweather.model.forecast

import com.pjkr.sunnyweather.longterm.model.Properties
import io.realm.RealmList

/**
 * Created by yabol on 23.08.2017.
 */
class WeatherTodayForecastResponse {
    var properties: RealmList<Properties>? = null

}