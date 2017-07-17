package com.pjkr.sunnyweather.longterm

import com.pjkr.sunnyweather.BasePresenter
import com.pjkr.sunnyweather.BaseView
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.model.Weather

/**
 * Created by konradrutkowski on 26.06.2017.
 */
interface WeatherContract{

    interface View{
        var presenter : Presenter
        fun showWeatherList(weatherList: List<Properties>)
        fun showWeather(weather: Weather)
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