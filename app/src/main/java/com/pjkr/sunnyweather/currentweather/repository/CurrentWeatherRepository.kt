package com.pjkr.sunnyweather.currentweather.repository

import android.util.Log
import com.pjkr.sunnyweather.BuildConfig
import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.model.WeatherResponse
import com.pjkr.sunnyweather.currentweather.net.WeatherAPI
import com.pjkr.sunnyweather.currentweather.presenter.CurrentWeatherPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by PJablonski on 28.06.2017.
 */
class CurrentWeatherRepository(var presenter: CurrentWeatherPresenter?): CurrentWeatherContract.Repository, Callback<WeatherResponse> {
    private var api: WeatherAPI? = null
    private val BASE_URL: String = "http://samples.openweathermap.org/data/2.5/"

    init {
        val retorfit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        this.api = retorfit.create(WeatherAPI::class.java)
    }
    override fun getWeatherInformation(cityName: String) {
        var call: Call<WeatherResponse>? = this.api?.getCurrentWeather(cityName, BuildConfig.WEATHER_API)
        call?.enqueue(this)
       // this.presenter?.weather = weather
    }

    override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
        Log.e("fail",  t?.message)
    }

    override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
        this.presenter?.weather = response?.body()?.weathers?.get(0)
    }
}