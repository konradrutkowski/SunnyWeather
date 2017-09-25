package com.pjkr.sunnyweather.welcome

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pjkr.sunnyweather.PermissionInteraction
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.startFragment

/**
 * Created by Konrad Rutkowski on 18.09.2017.
 */

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_holder)
        this.startFragment(R.id.fragment_container, NoLocationsFragment(), true, true, "WelcomeScreen", "Source")
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        when (currentFragment) {
            is PermissionInteraction -> currentFragment.handleThePermission(requestCode, permissions, grantResults)
        }
    }

    override fun onBackPressed() {
        // No way to get back :)
    }


}
