package com.pjkr.sunnyweather.utils

import android.util.Log
import com.pjkr.sunnyweather.longterm.model.WeatherDay
import java.util.*

/**
 * Created by yabol on 31.08.2017.
 */
fun Date.getWeatherDay(): WeatherDay {
    val calendar: Calendar = Calendar.getInstance()
    calendar.time = this
    val days = arrayOf(WeatherDay.SUNDAY, WeatherDay.MONDAY, WeatherDay.TUESDAY,
            WeatherDay.WEDNESDAY, WeatherDay.THURSDAY, WeatherDay.FRIDAY, WeatherDay.SATURDAY)
    val day: WeatherDay = days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
    Log.e("DayName", "Generated timeString name " + day)
    return day
}