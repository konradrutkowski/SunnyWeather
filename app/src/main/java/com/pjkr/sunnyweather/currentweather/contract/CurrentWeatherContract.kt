package com.pjkr.sunnyweather.currentweather.contract

import com.pjkr.sunnyweather.currentweather.model.Weather

/**
 * Created by PJablonski on 28.06.2017.
 */
class CurrentWeatherContract {
    interface View{
        fun displayWeathers()
        fun showLoadingIndicator()
        fun hideLoadingIndicator()
        fun showTemperature(temp: String)
        fun showHeaderIcon(iconName: String?)
        fun setPressure(pressure: String?)
        fun setCityName(cityName: String?)
        fun setTemperatureInfo(weatherName: String?, weatherDescription: String?)
        fun setMinTemp(temp: String)
        fun setMaxTemp(temp: String)
        fun setWeathersList(weathers: List<Weather>)
    }
    interface Presenter{
        fun loadCurrentWeather(cityName: String)
        fun loadNextDaysWeather(cityName: String)
    }
    interface Provider{
        fun getCount(): Int
        fun getWeather(position: Int): Weather?
    }
    interface Repository{
        fun getWeatherInformation(cityName: String)
    }
}