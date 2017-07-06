package com.pjkr.sunnyweather.longterm.presenter

import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.WeatherContract
import com.pjkr.sunnyweather.longterm.model.Weather

/**
 * Created by konradrutkowski on 26.06.2017.
 */
class LongTermWeatherPresenter(val view: WeatherContract.View, val repository: WeathersDataSource) : WeatherContract.Presenter {


    override fun onStart() {
        view.presenter = this
        this.loadData()
    }


    override fun loadData() {
        repository.getWeather(object: WeathersDataSource.GetWeatherCallback{
            override fun onFail() {
                view.showFailedDataFetch()
            }

            override fun onSuccess(weather: Weather) {
                view.showWeather(weather)
            }
        })

    }
//        repository.getWeatherList(object: WeathersDataSource.LoadWeathersCallback{
//            override fun onFail() {
//                view.showFailedDataFetch()
//            }
//
//            override fun onSuccess(weatherList: List<Weather>) {
//                view.showData(weatherList)
//            }
//        })
//
//    }
}