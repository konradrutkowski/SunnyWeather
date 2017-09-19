package com.pjkr.sunnyweather.welcome

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

/**
 * Created by root on 18.09.2017.
 */

class WelcomeActivity : AppCompatActivity() {

    private val LOCATION_REQUEST: Int = 600
    private lateinit var gpsLocation: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            LOCATION_REQUEST -> {
                when {
                    grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED -> {
                        addDynamicPosition()
                        Toast.makeText(this, "Permission is granted", Toast.LENGTH_SHORT).show()

                    }
                    else -> //TODO IF LIST OF MANUAL CITIES IS EMPTY
                        //showUserCityAddDialog()
                        Toast.makeText(this, "Permission is denied :( ", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    private fun checkAndRequestLocationPermission(): Boolean {
        when {
            !checkLocationPermission() -> {
                when {
                    ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) -> {
                        showExplanationDialog()
                    }
                    else -> {
                        ActivityCompat.requestPermissions(this,
                                Array(1, { Manifest.permission.ACCESS_FINE_LOCATION }),
                                LOCATION_REQUEST)
                    }
                }
                return false
            }
        }
        return true
    }

    private fun showExplanationDialog() {
        AlertDialog.Builder(this)
                .setTitle("Location permission")
                .setMessage("Access to your location is used when you want to add dynamic place. Is that okay?")
                .setPositiveButton(android.R.string.ok, { _, _ -> addDynamicPosition() })
                .setNegativeButton(android.R.string.no, { _, _ -> addDynamicPosition() })
                .setNeutralButton("Static place", { _, _ -> showManualPlaceInputDialog() })
                .show()
    }

    private fun addDynamicPosition() {
        if (checkAndRequestLocationPermission()) {
            Toast.makeText(this, "Success - added", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showManualPlaceInputDialog() {

    }

    private fun checkLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

}
