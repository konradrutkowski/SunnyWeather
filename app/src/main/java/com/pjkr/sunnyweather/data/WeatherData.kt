package com.pjkr.sunnyweather.data

import android.util.Log
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.model.Weather
import com.pjkr.sunnyweather.longterm.model.WeatherIcon

/**
 * Created by konrad on 25.07.2017.
 */

class WeatherData {

    fun chooseIcon(weather: Weather) : Weather {
        for (prop: Properties in weather.list!!) {
            Log.e("SearchingForIcon", "For property: "+prop.toString())
            var icon: WeatherIcon
            if (prop.clouds!! > 25) {
                icon = WeatherIcon.CLOUD

                if (prop.rain!= null && prop.rain!! >= 1.5) {
                    icon = WeatherIcon.RAIN
                }

                if (prop.snow != null && prop.snow!! >= 0.1 && prop.snow!! > prop.rain!!) {
                    icon = WeatherIcon.SNOW
                }

            } else {
                icon = WeatherIcon.SUN
            }
            prop.icon = icon
        }
        return weather
    }


}
