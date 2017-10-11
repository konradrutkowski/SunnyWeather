package com.pjkr.sunnyweather.welcome.nolocation

import android.content.Context
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.data.usercity.LocalUserCity
import com.pjkr.sunnyweather.data.usercity.UserCityData
import com.pjkr.sunnyweather.data.weather.WeathersDataSource
import com.pjkr.sunnyweather.data.weather.remote.RemoteDataSource
import com.pjkr.sunnyweather.location.LocationProvider

/**
 * Created by Konrad Rutkowski on 11.10.2017.
 * This file is created for project SunnyWeather.
 */

class NoLocationPresenter(var view: NoLocationContract.View) : NoLocationContract.Presenter {


    override fun addGPSLocation(context: Context) {
        val loc = LocationProvider(context).getLastLocation()
        if (loc != null) {
            RemoteDataSource.getCurrentWeatherByLatLon(loc.latitude.toString(), loc.longitude.toString(),
                    object : WeathersDataSource.GetWeatherCallback {
                        override fun onSuccess(weather: Weather) {
                            LocalUserCity.save(UserCityData(weather.city?.name!!, false))
                            view.startWeatherFragment(weather.city?.name!!)
                        }

                        override fun onFail() {
                            view.locationDataIsNotAvailable()
                        }
                    })
        }
        view.locationDataIsNotAvailable()
    }
}
