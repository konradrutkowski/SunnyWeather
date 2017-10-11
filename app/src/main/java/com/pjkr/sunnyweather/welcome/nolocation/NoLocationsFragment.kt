package com.pjkr.sunnyweather.welcome.nolocation

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pjkr.sunnyweather.PermissionInteraction
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.RequestCodes.LOCATION_REQUEST
import com.pjkr.sunnyweather.data.usercity.LocalUserCity
import com.pjkr.sunnyweather.data.usercity.UserCityData
import com.pjkr.sunnyweather.startFragment
import com.pjkr.sunnyweather.welcome.inputlocation.InputLocationFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.welcome_screen_layout.*

/**
 * Created by Konrad Rutkowski on 19.09.2017.
 * This file is created for project SunnyWeather.
 */

class NoLocationsFragment : Fragment(), PermissionInteraction, NoLocationContract.View {

    var noLocationPresenter: NoLocationPresenter = NoLocationPresenter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.welcome_screen_layout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.with(activity).load(R.drawable.sun_512x512).fit().centerCrop().into(welcome_picture)
        button_auto.setOnClickListener({ addDynamicPosition() })
        button_add_place.setOnClickListener({ startInputLocationFragment() })
    }

    override fun handleThePermission(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        Log.e("Permissions", "Permission event - request code " + requestCode)
        when (requestCode) {
            LOCATION_REQUEST -> {
                when { activity.isPermissionResultPositive(grantResults)
                -> {
                    addDynamicPosition()
                    Toast.makeText(context, "Permission is granted", Toast.LENGTH_SHORT).show()
                }
                    else -> {
                        Toast.makeText(context, "Permission is denied :( ", Toast.LENGTH_SHORT)
                                .show()
                    }
                }
                return
            }
        }
    }


    private fun startInputLocationFragment() {
        (activity as AppCompatActivity).startFragment(R.id.fragment_container,
                InputLocationFragment(), true, true, "Input", "Source")
    }

    private fun checkAndRequestLocationPermission(): Boolean {
        when { !this.checkLocationPermission() -> {
            when { isRationaleNeeded() -> {
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
                .setNegativeButton(android.R.string.no, { _, _ -> startInputLocationFragment() })
                .show()
    }

    private fun addDynamicPosition() {
        if (checkAndRequestLocationPermission()) {
            Toast.makeText(context, "Success - added", Toast.LENGTH_SHORT).show()
            LocalUserCity.save(UserCityData("", true))
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

    private fun checkLocationPermission(): Boolean =
            activity.checkLocationPermission()

}
fun Context.checkLocationPermission(): Boolean =
        ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

fun Activity.isPermissionResultPositive(grantResults: IntArray): Boolean =
        grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED
