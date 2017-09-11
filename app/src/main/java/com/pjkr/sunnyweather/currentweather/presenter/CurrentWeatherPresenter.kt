package com.pjkr.sunnyweather.currentweather.presenter

import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.utils.celsiusFromKelvin
import com.pjkr.sunnyweather.utils.formatDouble
import io.realm.RealmList

/**
 * Created by PJablonski on 28.06.2017.
 */
class CurrentWeatherPresenter
(var view: CurrentWeatherContract.View,
 var dataSource: WeathersDataSource)
    : CurrentWeatherContract.Presenter, CurrentWeatherContract.Provider {

    var weathers: List<Weather>? = null

    var weather: Weather? = null


    override fun getCount(): Int {
        return this.weathers?.size as Int
    }

    fun showWeather(weather: Weather) {
        this.weather = weather

        val celsiusTemp = weather.data?.temp?.celsiusFromKelvin().formatDouble()
        this.view.showTemperature(celsiusTemp)
        this.view.setCityName(weather.name)

        val iconName: String? = "weather_" + weather.mainIcon?.replace('n', 'd')
        this.view.showHeaderIcon(iconName)
        this.view.setTemperatureInfo(weather.main, weather.description)
        this.view.setPressure(weather.data?.pressure.toString())
        this.view.setMinTemp(weather.data?.minTemp?.celsiusFromKelvin().formatDouble())
        this.view.setMaxTemp(weather.data?.maxTemp?.celsiusFromKelvin().formatDouble())
    }


    override fun getWeather(position: Int): Weather? {
        return this.weathers?.get(position)
    }

    override fun loadCurrentWeather(cityName: String) {
        this.view.showLoadingIndicator()
        this.dataSource.getCurrentWeather(cityName, object: WeathersDataSource.GetWeatherCallback {
            override fun onSuccess(weather: Weather) {
                showWeather(weather)
            }

            override fun onFail() {
            }
        })
    }

    override fun loadNextDaysWeather(cityName: String) {
        this.dataSource.getTodayForecast(cityName, object: WeathersDataSource.LoadWeathersCallback{
            override fun onSuccess(weatherList: List<Weather>?) {
                view.setWeathersList(weatherList)
            }

            override fun onFail() {
            }

        })
    }

    fun setWeathersList(weathers: List<Weather>) {
        this.weathers = weathers
        this.view.displayWeathers()
    }
}