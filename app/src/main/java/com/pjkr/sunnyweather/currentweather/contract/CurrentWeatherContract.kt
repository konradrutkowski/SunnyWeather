package com.pjkr.sunnyweather.currentweather.contract

import com.pjkr.sunnyweather.currentweather.model.Weather

/**
 * Created by PJablonski on 28.06.2017.
 */
class CurrentWeatherContract {
    interface View{
        fun displayWeather(weather: Weather)
        fun displayWeathers()
        fun showLoadingIndicator()
        fun hideLoadingIndicator()
    }
    interface Presenter{
        fun loadElements(cityName: String)
    }
    interface Provider{
        fun getCount(): Int
        fun getWeather(position: Int): Weather?
    }
    interface Repository{
        fun getWeatherInformation(cityName: String)
    }
}