package com.pjkr.sunnyweather.welcome

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.pjkr.sunnyweather.PermissionInteraction
import com.pjkr.sunnyweather.R
import com.squareup.picasso.Picasso

/**
 * Created by root on 19.09.2017.
 */

class NoLocationsFragment : Fragment(), PermissionInteraction {

    private val LOCATION_REQUEST: Int = 600
    private lateinit var gpsLocation: Button

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.welcome_screen_layout, container, false)
        val welcomePicture = view?.findViewById(R.id.welcome_picture) as ImageView
        gpsLocation = view.findViewById(R.id.button_auto) as Button
        Picasso.with(activity).load(R.drawable.sun_512x512).fit().centerCrop().into(welcomePicture)
        gpsLocation.setOnClickListener({ addDynamicPosition() })
        return view
    }

    override fun handleThePermission(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        Log.e("Permissions", "Permission event - request code " + requestCode)
        when (requestCode) {
            LOCATION_REQUEST -> {
                when {
                    grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED -> {
                        addDynamicPosition()
                        Toast.makeText(context, "Permission is granted", Toast.LENGTH_SHORT).show()

                    }
                    else -> //TODO IF LIST OF MANUAL CITIES IS EMPTY
                        //showUserCityAddDialog()
                        Toast.makeText(context, "Permission is denied :( ", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    private fun checkAndRequestLocationPermission(): Boolean {
        when {
            !checkLocationPermission() -> {
                when {
                    isRationaleNeeded() -> {
                        showExplanationDialog()
                    }
                    else -> {
                        requestLocationPermission()
                    }
                }
                return false
            }
        }
        return true
    }

    private fun showExplanationDialog() {
        AlertDialog.Builder(activity)
                .setTitle("Location permission")
                .setMessage("Access to your location is used when you want to add dynamic place. Is that okay?")
                .setPositiveButton(android.R.string.ok, { _, _ -> requestLocationPermission() })
                .setNegativeButton(android.R.string.no, { _, _ -> Log.e("Permission", "Canceled") })
                //.setNeutralButton("Static place", { _, _ -> showManualPlaceInputDialog() })
                .show()
    }

    private fun addDynamicPosition() {
        if (checkAndRequestLocationPermission()) {
            Toast.makeText(context, "Success - added", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(activity,
                Array(1, { Manifest.permission.ACCESS_FINE_LOCATION }),
                LOCATION_REQUEST)
    }

    private fun isRationaleNeeded(): Boolean =
            ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.ACCESS_FINE_LOCATION)

    private fun showManualPlaceInputDialog() {

    }

    private fun checkLocationPermission(): Boolean =
            ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
}
