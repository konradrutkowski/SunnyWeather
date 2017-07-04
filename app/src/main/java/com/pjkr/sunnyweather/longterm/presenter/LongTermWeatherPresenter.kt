package com.pjkr.sunnyweather.longterm.presenter

import com.pjkr.sunnyweather.longterm.WeatherContract

/**
 * Created by konradrutkowski on 26.06.2017.
 */
class LongTermWeatherPresenter(val view: WeatherContract.View) : WeatherContract.Presenter {


    override fun onStart() {
        this.loadData()
    }


    override fun loadData() {
    }
}