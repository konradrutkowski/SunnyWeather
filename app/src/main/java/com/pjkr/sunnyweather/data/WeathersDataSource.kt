package com.pjkr.sunnyweather.data


import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.longterm.model.Properties
import io.realm.Realm
import io.realm.RealmList

/**
 * Created by konradrutkowski on 04.07.2017.
 */

public interface WeathersDataSource {

    fun getWeatherList(city: String, numberOfDays: String, loadWeathersCallback: LoadWeathersCallback)

    fun getActivatedWeathers(loadWeathersCallback: LoadWeathersCallback)

    fun getDeclinedWeathers(loadWeathersCallback: LoadWeathersCallback)

    fun getLongtermWeather(city:String, getWeatherCallback: LoadWeathersCallback)

    fun getCurrentWeather(cityName: String, callback: GetWeatherCallback)

    fun getTodayForecast(cityName: String, callback: LoadWeathersCallback)

    fun saveWeather(weather: Weather)

    fun saveLongtermForecast(weathers: List<Weather>?): List<Weather>?

    fun saveCurrentDayForecast(cityName: String, weathers: List<Weather>?)

    interface LoadWeathersCallback {

        fun onSuccess(weatherList: List<Weather>?)

        fun onFail()
    }

    interface GetWeatherCallback {

        fun onSuccess(weather: Weather)

        fun onFail()
    }

}
