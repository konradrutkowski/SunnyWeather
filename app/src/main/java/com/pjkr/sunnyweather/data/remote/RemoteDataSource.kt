package com.pjkr.sunnyweather.data.remote


import android.util.Log
import com.pjkr.sunnyweather.api.WeatherProvider
import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.model.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by konradrutkowski on 04.07.2017.
 */

object RemoteDataSource : WeathersDataSource {

    override fun getWeatherList(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {
            WeatherProvider().getWeather(object : Callback<Weather> {
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

    override fun getWeather(getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
        WeatherProvider().getWeather(object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                Log.e("Request", " Response response = " + response.isSuccessful)
                Log.e("Request", " Value = " + response.body()!!.toString())
                getWeatherCallback.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Log.e("Request", " FAILED")
                Log.e("Request", " FAILED" + call.request().url())
                t.printStackTrace()
                getWeatherCallback.onFail()
            }
        })
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
