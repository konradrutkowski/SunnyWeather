package com.pjkr.sunnyweather.longterm

import com.pjkr.sunnyweather.BasePresenter
import com.pjkr.sunnyweather.BaseView
import com.pjkr.sunnyweather.longterm.model.Weather

/**
 * Created by konradrutkowski on 26.06.2017.
 */
interface WeatherContract{

    interface View{
        var presenter : Presenter
        fun showWeatherList(weatherList: List<Weather>)
        fun showWeather(weather: Weather)
        fun setAdapter()
        fun showFailedDataFetch()

    }


    interface Presenter{
        fun loadData()
        fun onStart()

    }



}