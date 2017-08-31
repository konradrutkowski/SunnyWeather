package com.pjkr.sunnyweather

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.pjkr.sunnyweather.currentweather.fragment.CurrentWeatherFragment
import com.pjkr.sunnyweather.longterm.view.LongTermWeatherFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_component.view.*


class MainActivity : AppCompatActivity() {

    private val LOCATION_REQUEST: Int = 600

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locationPermissionCheck()
        currentWeatherTab.tabName.text = getString(R.string.current_tab)
        longTermTab.tabName.text = getString(R.string.long_term_tab)

        currentWeatherTab.tabName.setOnClickListener { startCurrentWeatherFragment() }
        longTermTab.tabName.setOnClickListener { startLongTermWeatherFragment() }

        if (savedInstanceState == null) {
            startCurrentWeatherFragment()
        }

    }

    fun locationPermissionCheck(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ){

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                         Array(1,{Manifest.permission.ACCESS_FINE_LOCATION}),
                        LOCATION_REQUEST)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    private fun startCurrentWeatherFragment(){
        currentWeatherTab.showUnderline()
        longTermTab.hideUnderline()
        startFragment(R.id.container, CurrentWeatherFragment(), true, false, null)
    }

    private fun startLongTermWeatherFragment(){
        currentWeatherTab.hideUnderline()
        longTermTab.showUnderline()
        startFragment(R.id.container, LongTermWeatherFragment(), true, false, null)
    }

    private fun obtainLastKnownLocation(){
        if(checkLocationPermission()) {
            val locationProvider = LocationManager.NETWORK_PROVIDER
            val lastKnownLocation: Location = (this.getSystemService(Context.LOCATION_SERVICE) as LocationManager).getLastKnownLocation(locationProvider)
            Log.e("Location", "Last know location - "+lastKnownLocation)
        }

    }

    private fun checkLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            LOCATION_REQUEST -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    obtainLastKnownLocation()

                } else {
                    Toast.makeText(this, "Permission is denied :( ", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

}
