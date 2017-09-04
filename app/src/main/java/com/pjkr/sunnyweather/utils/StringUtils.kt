package com.pjkr.sunnyweather.utils

/**
 * Created by yabol on 31.08.2017.
 */
fun String.extractTimeFromDateTime(): String{
    val spacePosition = this.indexOf(" ")
    return this.substring(spacePosition, this.length)
}

fun String.extractDateFromDateTime(): String{
    val spacePosition = this.indexOf(" ")
    return this.substring(0, spacePosition)
}
