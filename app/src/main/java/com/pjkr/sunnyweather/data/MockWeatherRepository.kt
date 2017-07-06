package com.pjkr.sunnyweather.data


import com.pjkr.sunnyweather.api.WeatherProvider
import com.pjkr.sunnyweather.longterm.model.Weather

import java.util.ArrayList

/**
 * Created by konradrutkowski on 04.07.2017.
 */

class MockWeatherRepository : WeathersDataSource {


    private var weatherList: List<Weather> = ArrayList()

    init {
        fillMockListWithData()
    }

    override fun getWeatherList(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {
        loadWeathersCallback.onSuccess(weatherList)
    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {
        loadWeathersCallback.onSuccess(weatherList)
    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {
        loadWeathersCallback.onSuccess(weatherList)
    }

    override fun getWeather(getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
    }

    private fun fillMockListWithData() {

        val weather: Weather = Weather()
        weather.cod = "Elo"
        weather.cnt = 1
        weather.message = 20.0
        weatherList += weather
        //        weatherList.add(new Weather("Headphones microphone is not working", "Janusz", "24.05.2017"));
        //        weatherList.add(new Weather("Wash machine - weird sounds", "Andrew", "23.05.2017"));
        //        weatherList.add(new Weather("Laptop is over heating", "Janusz", "21.05.2017"));
        //        weatherList.add(new Weather("Handy - broken screen", "Janusz", "30.05.2017"));
        //        weatherList.add(new Weather("Handy - charging slot issues", "Janusz", "3.06.2017"));
    }
}
