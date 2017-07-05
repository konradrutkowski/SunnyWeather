package com.pjkr.sunnyweather.api


import android.support.annotation.RestrictTo
import android.util.Log

import com.pjkr.sunnyweather.longterm.model.Weather

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by konradrutkowski on 28.06.2017.
 */

class WeatherProvider {

    val BASE_URL = "http://api.openweathermap.org"
    val retrofit: Retrofit
    val mapAPI: MapAPI


    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        mapAPI = retrofit.create(MapAPI::class.java)
    }

    fun getWeather() {
        val weatherCall = mapAPI.getWeather("London", "7", "3a6092b5c20245c7b5b76a920b2d9208")
        weatherCall.enqueue(object : Callback<Weather> {
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

}
