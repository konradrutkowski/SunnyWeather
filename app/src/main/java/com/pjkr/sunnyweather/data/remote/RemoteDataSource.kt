package com.pjkr.sunnyweather.data.remote


import android.util.Log
import com.pjkr.sunnyweather.data.WeatherData
import com.pjkr.sunnyweather.api.WeatherProvider
import com.pjkr.sunnyweather.api.dto.LongtermForecastResponse
import com.pjkr.sunnyweather.api.dto.WeatherResponse
import com.pjkr.sunnyweather.api.dto.WeatherTodayForecastResponse
import com.pjkr.sunnyweather.currentweather.model.*
import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.utils.getWeatherDay
import io.realm.RealmList
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
        WeatherProvider().getWeather(city, numberOfDays, object : Callback<LongtermForecastResponse> {
            override fun onResponse(call: Call<LongtermForecastResponse>?, response: Response<LongtermForecastResponse>?) {
                Log.e("Request", " Response response = " + response?.isSuccessful)
                if (response?.body() != null) {
                    Log.e("Request", " Value = " + response.body()!!.toString())
                    var weather = proceedListResponse(response.body()!!)
                    loadWeathersCallback.onSuccess(weather)
                }else{
                    loadWeathersCallback.onFail()
                }
            }

            override fun onFailure(call: Call<LongtermForecastResponse>?, t: Throwable?) {
                Log.e("Request", " FAILED")
                Log.e("Request", " FAILED" + call?.request()?.url())
                t?.printStackTrace()
                loadWeathersCallback.onFail()
            }

        })
    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getLongtermWeather(city: String, getWeatherCallback: WeathersDataSource.LoadWeathersCallback) {
        WeatherProvider().getWeather(city, "16", object : Callback<LongtermForecastResponse> {
            override fun onResponse(call: Call<LongtermForecastResponse>, response: Response<LongtermForecastResponse>?) {
                if (response?.body() != null) {
                    var weather: List<Weather> = proceedListResponse(response.body()!!)
                    getWeatherCallback.onSuccess(weather)
                    return
                }
                getWeatherCallback.onFail()
            }

            override fun onFailure(call: Call<LongtermForecastResponse>, t: Throwable) {
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
                var weatherObj = Weather()
                weatherObj.id = weather?.id
                weatherObj.main = weather?.main
                weatherObj.description = weather?.description
                weatherObj.mainIcon = weather?.mainIcon
                weatherObj.coord = response?.body()?.coord
                weatherObj.data = response?.body()?.main
                weatherObj.wind = response?.body()?.wind
                weatherObj.visibility = response?.body()?.visibility
                weatherObj.name = cityName
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
                    val result = ArrayList<Weather>()
                    for(property in forecast?.properties!!){
                        if(property.weather != null){
                            result.add(createWeather(property)!!)
                        }
                    }
                    //forecast?.properties!!.mapTo(result) { createWeather(it)!! }
                    callback.onSuccess(result)
                }else{
                    callback.onFail()
                }
            }

            override fun onFailure(call: Call<WeatherTodayForecastResponse>?, t: Throwable?) {
                callback.onFail()
            }

        })
    }

    private fun createWeather(property: Properties): Weather?{
        val weather = property.weather?.get(0)

        val data = Data()
        data.temp = property.temp?.day
        data.maxTemp = property.temp?.max
        data.minTemp = property.temp?.min
        data.pressure = property.pressure?.toInt()
        data.humidity = property.humidity
        weather?.data = data

        val wind = Wind()

        wind.deg = property.deg
        wind.speed = property.speed

        weather?.wind = wind

        val clouds = Clouds()
        clouds.all = property.clouds

        weather?.timeString = property.timeString
        weather?.listIcon = property.icon
        weather?.dayOfTheWeek = property.dayOfTheWeek
        return weather
    }

    private fun getNext9Elements(properties: List<Properties>?): List<Properties>{
        var result = RealmList<Properties>()
        if(properties != null) {
            (0..8).mapTo(result) { properties.get(it) }
        }
        return result
    }


    private fun fillWeatherIcon(properties: List<Properties>): List<Properties> {
        return WeatherData().chooseIcon(properties)
    }

    private fun fillResponseWithDates(weather: LongtermForecastResponse): List<Properties> {
        return getNextDays(weather)
    }

    private fun getNextDays(weather: LongtermForecastResponse): List<Properties> {
        val properties: List<Properties> = weather.list!!
        val cal: Calendar = Calendar.getInstance()
        cal.time = Date()
        for (i in 1..properties.size) {
                cal.add(Calendar.DATE, 1)
                val dateStr: String = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)) + "." + String.format("%02d", cal.get(Calendar.MONTH))
                properties[i - 1].timeString = dateStr
                properties[i - 1].dayOfTheWeek = cal.time.getWeatherDay()
        }
        return properties

    }

    private fun proceedListResponse(weather: LongtermForecastResponse) : List<Weather>{
        fillResponseWithDates(weather)
        val properties = fillWeatherIcon(weather.list!!)

        val result = ArrayList<Weather>()
        properties.mapTo(result) { createWeather(it)!! }
        return result
    }

    override fun saveWeather(weather: Weather) {
        // not implemented in remote data source
    }

    override fun saveLongtermForecast(weathers: List<Weather>?): RealmList<Weather>? {
        // not implemented in remote data source
        return null
    }

    override fun saveCurrentDayForecast(cityName: String, weathers: List<Weather>?) {
        // not implemented in remote data source
    }

}
