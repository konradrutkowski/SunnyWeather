package com.pjkr.sunnyweather.currentweather.data.remote

import com.pjkr.sunnyweather.api.WeatherProvider
import com.pjkr.sunnyweather.currentweather.data.WeatherDataSource
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by yabol on 24.07.2017.
 */
object WeatherRemoteSource : WeatherDataSource {

    override fun getCurrentWeather(cityName: String, callback: WeatherDataSource.OnDataCollectedCallback<Weather>) {
        WeatherProvider().getCurrentWeather(cityName, object: Callback<WeatherResponse>{
            override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
                val weather: Weather? = response?.body()?.weathers?.get(0)
                var weatherObj: Weather = Weather(weather?.id, weather?.main, weather?.description, weather?.icon)
                weatherObj.coord = response?.body()?.coord
                weatherObj.data = response?.body()?.main
                weatherObj.wind = response?.body()?.wind
                weatherObj.visibility = response?.body()?.visibility
                weatherObj.name = response?.body()?.name
                if (weather != null) {
                    callback.onSuccess(weatherObj)
                }
            }

            override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) { }

        })
    }

    override fun getNextFiveDaysWeather(cityName: String, callback: WeatherDataSource.OnDataCollectedCallback<List<Weather>>) {
    }

    override fun saveWeather(weather: Weather) {
    }


}

