package com.pjkr.sunnyweather.location

import android.content.Context
import android.location.Location
import android.location.LocationManager
import com.pjkr.sunnyweather.welcome.nolocation.checkLocationPermission

/**
 * Created by Konrad Rutkowski on 11.10.2017.
 * This file is created for project SunnyWeather.
 */
class LocationProvider(var context: Context) {

    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    fun getLastLocation(): Location? {
        var bestLocation: Location? = null
        if (context.checkLocationPermission()) {
            val providers = locationManager.getProviders(true)
            for (provider in providers) {
                val location = locationManager.getLastKnownLocation(provider) ?: continue
                if (bestLocation == null || location.accuracy < bestLocation.accuracy) {
                    bestLocation = location
                }
            }
        }
        return bestLocation

    }
}
