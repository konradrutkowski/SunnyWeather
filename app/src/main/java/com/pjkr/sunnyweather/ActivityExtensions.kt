package com.pjkr.sunnyweather


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by yabol on 17.07.2017.
 */

fun AppCompatActivity.startFragment(
        id: Int,
        fragment: Fragment,
        replace: Boolean = false,
        addToBackStack: Boolean = false,
        tag: String?
) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

    when {
        replace -> transaction.replace(id, fragment)
        else -> transaction.add(id, fragment)
    }
    when {
        addToBackStack -> transaction.addToBackStack(tag)
    }

    transaction.commit()
}