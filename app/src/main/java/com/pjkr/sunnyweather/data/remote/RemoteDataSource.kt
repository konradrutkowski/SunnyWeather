package com.pjkr.sunnyweather.data.remote


import android.util.Log
import com.pjkr.sunnyweather.data.WeatherData
import com.pjkr.sunnyweather.api.WeatherProvider
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.model.WeatherDay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


/**
 * Created by konradrutkowski on 04.07.2017.
 */

object RemoteDataSource : WeathersDataSource {

    override fun getWeatherList(city: String, loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {
        WeatherProvider().getWeather(city, object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                Log.e("Request", " Response response = " + response.isSuccessful)
                Log.e("Request", " Value = " + response.body()!!.toString())
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.e("Request", " FAILED")
                Log.e("Request", " FAILED" + call.request().url())
                t.printStackTrace()
            }
        })
    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getWeather(city: String, getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
        WeatherProvider().getWeather(city, object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.body() != null) {
                    var weather: Weather = fillResponseWithDates(response.body()!!)
                    weather = fillWeatherIcon(weather)
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

    fun fillWeatherIcon(weather: Weather): Weather {
        return WeatherData().chooseIcon(weather)
    }

    fun fillResponseWithDates(weather: Weather): Weather {
        val weather : Weather = getNext16Days(weather)
        return weather
    }

    fun getNext16Days(weather: Weather): Weather {
        val properties: List<Properties> = weather.list!!
        val date: Date = Date()
        val arr: Array<String> = Array(16, { _ -> "" })
        val cal: Calendar = Calendar.getInstance()
        cal.time = date
        for (i in 1..16) {
            cal.add(Calendar.DATE, 1)
            val dateStr: String = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)) + "." + String.format("%02d", cal.get(Calendar.MONTH))
            arr[i - 1] = dateStr
            properties[i -1].day = dateStr
            properties[i -1].dayOfTheWeek = getNameOfTheDay(cal.time)
        }
        Log.e("Next16", "Dates = " + arr.contentToString())
        return weather

    }

    fun getNameOfTheDay(date: Date): WeatherDay {
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = date
        val days = arrayOf(WeatherDay.SUNDAY, WeatherDay.MONDAY, WeatherDay.TUESDAY,
                WeatherDay.WEDNESDAY, WeatherDay.THURSDAY, WeatherDay.FRIDAY, WeatherDay.SATURDAY)
        val day: WeatherDay = days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
        Log.e("DayName", "Generated day name " + day)
        return day
    }

}
