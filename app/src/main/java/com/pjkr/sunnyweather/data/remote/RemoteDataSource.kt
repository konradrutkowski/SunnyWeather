package com.pjkr.sunnyweather.data.remote


import android.util.Log
import com.pjkr.sunnyweather.data.WeatherData
import com.pjkr.sunnyweather.api.WeatherProvider
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.model.WeatherResponse
import com.pjkr.sunnyweather.currentweather.model.forecast.WeatherTodayForecastResponse
import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.model.WeatherDay
import com.pjkr.sunnyweather.utils.getWeatherDay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


/**
 * Created by konradrutkowski on 04.07.2017.
 */

object RemoteDataSource : WeathersDataSource {

    override fun getWeatherList(city: String, numberOfDays: String, loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {
        WeatherProvider().getWeather(city, numberOfDays, object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                Log.e("Request", " Response response = " + response.isSuccessful)
                if (response.body() != null) {
                    Log.e("Request", " Value = " + response.body()!!.toString())
                    var weather = proceedListResponse(response.body()!!)
                    loadWeathersCallback.onSuccess(weather.list)
                }else{
                    loadWeathersCallback.onFail()
                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.e("Request", " FAILED")
                Log.e("Request", " FAILED" + call.request().url())
                t.printStackTrace()
                loadWeathersCallback.onFail()
            }
        })
    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getWeather(city: String, getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
        WeatherProvider().getWeather(city, "16", object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.body() != null) {
                    var weather: Weather = proceedListResponse(response.body()!!)
                    getWeatherCallback.onSuccess(weather)
                    return
                }
                getWeatherCallback.onFail()
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.e("Request", " FAILED")
                Log.e("Request", " FAILED" + call.request().url())
                t.printStackTrace()
                getWeatherCallback.onFail()
            }
        })
    }

    override fun getCurrentWeather(cityName: String, callback: WeathersDataSource.GetWeatherCallback) {
        WeatherProvider().getCurrentWeather(cityName, object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
                val weather: Weather? = response?.body()?.weathers?.get(0)
                var weatherObj = Weather(weather?.id, weather?.main, weather?.description, weather?.icon)
                weatherObj.coord = response?.body()?.coord
                weatherObj.data = response?.body()?.main
                weatherObj.wind = response?.body()?.wind
                weatherObj.visibility = response?.body()?.visibility
                weatherObj.name = response?.body()?.name
                if (weather != null) {
                    callback.onSuccess(weatherObj)
                } else {
                    callback.onFail()
                }
            }

            override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
                callback.onFail()
            }

        })
    }

    override fun getTodayForecast(cityName: String, callback: WeathersDataSource.LoadWeathersCallback) {
        WeatherProvider().getTodayForecast(cityName, object : Callback<WeatherTodayForecastResponse>{
            override fun onResponse(call: Call<WeatherTodayForecastResponse>?, response: Response<WeatherTodayForecastResponse>?) {
                Log.e("Request", " Response response = " + response?.isSuccessful)
                if (response?.body() != null) {
                    Log.e("Request", " Value = " + response.body()!!.toString())
                    var forecast = response.body()
                    forecast?.properties = getNext9Elements(forecast?.properties)
                    forecast?.properties = fillWeatherIcon(forecast?.properties!!)
                    callback.onSuccess(forecast?.properties)
                }else{
                    callback.onFail()
                }
            }

            override fun onFailure(call: Call<WeatherTodayForecastResponse>?, t: Throwable?) {
                callback.onFail()
            }

        })
    }

    private fun getNext9Elements(properties: List<Properties>?): List<Properties>{
        var result: ArrayList<Properties> = ArrayList<Properties>()
        if(properties != null) {
            (0..8).mapTo(result) { properties?.get(it) }
        }
        return result
    }


    private fun fillWeatherIcon(properties: List<Properties>): List<Properties> {
        return WeatherData().chooseIcon(properties)
    }

    private fun fillResponseWithDates(weather: Weather): Weather {
        return getNextDays(weather)
    }

    private fun getNextDays(weather: Weather): Weather {
        val properties: List<Properties> = weather.list!!
        val cal: Calendar = Calendar.getInstance()
        cal.time = Date()
        for (i in 1..properties.size) {
                cal.add(Calendar.DATE, 1)
                val dateStr: String = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)) + "." + String.format("%02d", cal.get(Calendar.MONTH))
                properties[i - 1].timeString = dateStr
                properties[i - 1].dayOfTheWeek = cal.time.getWeatherDay()
        }
        return weather

    }

    private fun proceedListResponse(weather: Weather) : Weather{
        fillResponseWithDates(weather)
        weather.list = fillWeatherIcon(weather.list!!)

        return weather
    }

}
