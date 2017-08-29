package com.pjkr.sunnyweather.utils

/**
 * Created by yabol on 13.07.2017.
 */

fun Double?.formatDouble() : String{
    return String.format("%.${0}f", this)
}
fun Double.celsiusFromKelvin(): Double {
    return this - 273.15
}