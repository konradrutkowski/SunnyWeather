package com.pjkr.sunnyweather.longterm.presenter

import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.WeatherContract


/**
 * Created by konradrutkowski on 26.06.2017.
 */
class LongTermWeatherPresenter(val view: WeatherContract.View, val repository: WeathersDataSource) : WeatherContract.Presenter {


    override fun onStart() {
        view.presenter = this
        this.loadData("London")
    }


    override fun loadData(city: String) {
        repository.getWeather(city, object: WeathersDataSource.GetWeatherCallback{
            override fun onFail() {
                view.showFailedDataFetch()
            }

            override fun onSuccess(weather: Weather) {
                view.showWeather(weather)
                view.hideLoadIndicator()
            }
        })

    }

}

