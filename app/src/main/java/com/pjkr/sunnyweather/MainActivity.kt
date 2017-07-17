package com.pjkr.sunnyweather

import android.content.ComponentName
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.pjkr.sunnyweather.longterm.view.LongTermWeatherFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment()
    }

    fun AppCompatActivity.startFragment() {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, LongTermWeatherFragment())
        fragmentTransaction.commit()
    }

}
