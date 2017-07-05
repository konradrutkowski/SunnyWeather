package com.pjkr.sunnyweather.api

import android.graphics.Movie
import com.pjkr.sunnyweather.longterm.model.Weather

import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by konradrutkowski on 28.06.2017.
 */

public interface MapAPI {
    @GET("/data/2.5/forecast/daily?q={city_name}&cnt={cnt}")
    fun getWeather(@Path("city_name") cityName: String, @Path("cnt") numberOfDays: String, @Query("&APPID=") keyApi: String, response: Callback<List<Weather>>)
}
