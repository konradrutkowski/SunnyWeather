package com.pjkr.sunnyweather.location

import android.Manifest
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.support.v4.app.ActivityCompat

class LocationService : Service(), LocationListener {

    private val lastBestLocation: Location? = null
    private val HALF_HOUR: Long = 30 * 60 * 100
    private val TEN_MINUTES: Long = 10 * 60 * 100


    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        requestForLocations()
        return Service.START_NOT_STICKY
    }


    private fun requestForLocations() {
        val criteria = Criteria()
        criteria.accuracy = Criteria.ACCURACY_FINE
        criteria.isAltitudeRequired = false
        criteria.isBearingRequired = false
        val locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val myProvider = locationManager.getBestProvider(criteria, true)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        locationManager.requestLocationUpdates(myProvider, HALF_HOUR, 100f, this)
    }

    fun stopRequest() {
        val locationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        locationManager.removeUpdates(this)
    }


    override fun onLocationChanged(location: Location) {
        if (isBetterLocation(location, lastBestLocation)) {
            //TODO SAVE or BROADCAST
        }
    }

    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

    }

    override fun onProviderDisabled(provider: String) {
        requestForLocations()
    }


    override fun onProviderEnabled(provider: String) {
        requestForLocations()
    }


    private fun isBetterLocation(location: Location, currentBestLocation: Location?): Boolean {
        if (currentBestLocation == null) {
            return true
        }
        val timespan = location.time - currentBestLocation.time
        val isMuchNewer = timespan > TEN_MINUTES
        val isMuchOlder = timespan < -TEN_MINUTES
        val isNewer = timespan > 0

        if (isMuchNewer) {
            return true
        } else if (isMuchOlder) {
            return false
        }

        val accuracyDelta = (location.accuracy - currentBestLocation.accuracy).toInt()
        val isLessAccurate = accuracyDelta > 0
        val isMoreAccurate = accuracyDelta < 0
        val isSignificantlyLessAccurate = accuracyDelta > 200

        val isSameProvider = isSameProvider(location.provider, currentBestLocation.provider)

        if (isMoreAccurate) {
            return true
        } else if (isNewer && !isLessAccurate) {
            return true
        } else if (isNewer && !isSignificantlyLessAccurate && isSameProvider) {
            return true
        }
        return false
    }

    private fun isSameProvider(firstProvider: String?, secondProvider: String?): Boolean {
        return if (firstProvider == null) {
            secondProvider == null
        } else firstProvider == secondProvider
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}