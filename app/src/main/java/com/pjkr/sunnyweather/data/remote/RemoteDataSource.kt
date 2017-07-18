package com.pjkr.sunnyweather.data.remote


import android.util.Log
import com.pjkr.sunnyweather.api.WeatherProvider
import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.model.Weather
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
                // Log.e("Request", " Response response = " + response.isSuccessful)
                // Log.e("Request", " Value = " + response.body()!!.toString())
                if (response.body() != null) {
                    var weather: Weather = fillResponseWithDates(response.body()!!)
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

    fun fillResponseWithDates(weather: Weather): Weather {
        var arr = getNext16Days()
        var ix: Int = 0
        for (prop: Properties in weather.list!!) {
            prop.stringDate = arr[ix++]
        }
        return weather
    }

    fun getNext16Days(): Array<String> {
        var date: Date = Date()
        var arr: Array<String> = Array(16, { i -> "" })
        val cal: Calendar = Calendar.getInstance()
        cal.time = date
        for (i in 1..16) {
            cal.add(Calendar.DATE, 1)
            var dateStr: String = String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)) + " " + String.format("%02d", cal.get(Calendar.MONTH))
            dateStr +=   " " + " "+ getNameOfTheDay(cal.time)
            arr[i - 1] = dateStr
        }
        Log.e("Next16", "Dates = " + arr.contentToString())
        return arr

    }

    fun getNameOfTheDay(date: Date): String {
        //var date: Date = Date()
        var calendar: Calendar = Calendar.getInstance()
        calendar.setTime(date)
        val days = arrayOf("ND", "PON", "WT", "SR", "CZW", "PT", "SOB")
        var day: String = days[calendar.get(Calendar.DAY_OF_WEEK) - 1]
        Log.e("DayName", "Generated day name "+ day)
        return day
    }

//    companion object {
//
//        private var INSTANCE: RemoteDataSource? = null
//
//        val instance: RemoteDataSource
//            get() {
//                if (INSTANCE == null) {
//                    INSTANCE = RemoteDataSource()
//                }
//                return INSTANCE!!
//            }
//    }
}
