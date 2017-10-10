package com.pjkr.sunnyweather.longterm

import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.longterm.model.Properties

/**
 * Created by konradrutkowski on 26.06.2017.
 */
interface WeatherContract{

    interface View{
        var presenter : Presenter
        fun showWeatherList(weatherList: List<Weather>?)
        fun setAdapter()
        fun showFailedDataFetch()
        fun showLoadIndicator()
        fun hideLoadIndicator()
    }

    interface Presenter{
        fun loadData(city: String)
        fun onStart()

    }



}