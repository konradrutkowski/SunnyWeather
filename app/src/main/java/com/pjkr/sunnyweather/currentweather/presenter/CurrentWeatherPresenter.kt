package com.pjkr.sunnyweather.currentweather.presenter

import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.utils.celciusFromFarenheit
import com.pjkr.sunnyweather.utils.formatDouble
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

    fun showWeather(weather: Weather){
        this.weather = weather

        val celsiusTemp = weather.data?.temp?.celciusFromFarenheit().formatDouble()
        this.view.showTemperature(celsiusTemp.toString())
        this.view.setCityName(weather.name)

        val iconName: String? = "weather_" + weather.icon
        this.view.showHeaderIcon(iconName)
        this.view.setTemperatureInfo(weather.main, weather.description)
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