package com.pjkr.sunnyweather.currentweather.presenter

import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.model.Weather
import java.security.Provider

/**
 * Created by PJablonski on 28.06.2017.
 */
class CurrentWeatherPresenter(var view: CurrentWeatherContract.View)
    : CurrentWeatherContract.Presenter, CurrentWeatherContract.Provider {
    var weathers: List<Weather>? = null
    var repository: CurrentWeatherContract.Repository? = null
    var weather: Weather? = null


    override fun getCount(): Int {
        return this.weathers?.size as Int
    }

    override fun getWeather(position: Int): Weather? {
        return this.weathers?.get(position)
    }

    override fun loadElements(cityName: String) {
        this.view.showLoadingIndicator()
        this.repository?.getWeatherInformation(cityName)
    }

    fun setWeathersList(weathers: List<Weather>){
        this.weathers = weathers
        this.view.displayWeathers()
    }
}