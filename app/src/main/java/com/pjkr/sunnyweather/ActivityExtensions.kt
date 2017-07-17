package com.pjkr.sunnyweather


import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by yabol on 17.07.2017.
 */

fun AppCompatActivity.startFragment(id: Int, fragment: Fragment, tag: String?){
    supportFragmentManager
            .beginTransaction()
            .add(id, fragment, tag)
            .commitAllowingStateLoss()
}