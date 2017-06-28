package com.pjkr.sunnyweather.currentweather.repository

import com.pjkr.sunnyweather.BuildConfig
import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.net.WeatherAPI
import com.pjkr.sunnyweather.currentweather.presenter.CurrentWeatherPresenter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by PJablonski on 28.06.2017.
 */
class CurrentWeatherRepository: CurrentWeatherContract.Repository {
    var presenter: CurrentWeatherPresenter? = null
    private var api: WeatherAPI? = null
    private val BASE_URL: String = ""

    init {
        val retorfit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        this.api = retorfit.create(WeatherAPI::class.java)
    }
    override fun getWeatherInformation(cityName: String) {
        val weather: Weather? = this.api?.getCurrentWeather(cityName, BuildConfig.WEATHER_API)?.weathers?.get(0)
        this.presenter?.weather = weather
    }
}