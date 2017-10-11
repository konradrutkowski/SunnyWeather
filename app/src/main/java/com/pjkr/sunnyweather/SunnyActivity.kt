package com.pjkr.sunnyweather

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import com.pjkr.sunnyweather.currentweather.fragment.CurrentWeatherFragment
import com.pjkr.sunnyweather.longterm.view.LongTermWeatherFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_component.view.*




class SunnyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currentWeatherTab.tabName.text = getString(R.string.current_tab)
        longTermTab.tabName.text = getString(R.string.long_term_tab)

        currentWeatherTab.tabName.setOnClickListener { startCurrentWeatherFragment() }
        longTermTab.tabName.setOnClickListener { startLongTermWeatherFragment() }

        if (savedInstanceState == null) {
            startCurrentWeatherFragment()
        }
    }

    private fun startCurrentWeatherFragment() {
        currentWeatherTab.showUnderline()
        longTermTab.hideUnderline()
        startFragment(R.id.container, CurrentWeatherFragment(), true, false, null)
    }

    private fun startLongTermWeatherFragment() {
        currentWeatherTab.hideUnderline()
        longTermTab.showUnderline()
        startFragment(R.id.container, LongTermWeatherFragment(), true, false, null)
    }

    private fun obtainLastKnownLocation() {
        if (checkLocationPermission()) {
            val locationProvider = LocationManager.NETWORK_PROVIDER
            val lastKnownLocation: Location = (this.getSystemService(Context.LOCATION_SERVICE) as LocationManager).getLastKnownLocation(locationProvider)
            Log.e("Location", "Last know location - " + lastKnownLocation)
        }
    }

    private fun checkLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }


    fun showUserCityAddDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add new city")
        val viewInflated = LayoutInflater.from(this).inflate(R.layout.add_new_city_dialog_layout,  window.decorView as ViewGroup, false)
        val input = viewInflated.findViewById(R.id.input) as EditText
        builder.setView(viewInflated)
        builder.setPositiveButton(android.R.string.ok, { dialog, _ ->
            Log.e("Save", "New city should be added "+input.text)
            dialog.dismiss()

        })
        builder.setNegativeButton(android.R.string.cancel, { dialog, _ -> dialog.cancel() })
        builder.show()
    }
}
