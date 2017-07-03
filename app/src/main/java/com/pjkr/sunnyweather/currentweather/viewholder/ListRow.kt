package com.pjkr.sunnyweather.currentweather.viewholder

/**
 * Created by yabol on 03.07.2017.
 */
interface ListRow{
    fun getValues(key: String): String
    fun getType(): Int
}