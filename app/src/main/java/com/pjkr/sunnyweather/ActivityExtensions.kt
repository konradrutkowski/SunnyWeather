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
        tag: String? = "",
        sourceTag: String? = ""

) {
    var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

    transaction = when {
        replace -> transaction.replace(id, fragment, tag)
        else -> transaction.add(id, fragment, tag)
    }
    when {
        addToBackStack -> transaction = transaction.addToBackStack(sourceTag)
    }

    transaction.commit()
}