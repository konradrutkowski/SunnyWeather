package com.pjkr.sunnyweather.location

/**
 * Created by root on 31.08.2017.
 */
public class CurrentLocation private constructor() {

    private object Holder { val INSTANCE = CurrentLocation() }

    companion object {
        val instance: CurrentLocation by lazy { Holder.INSTANCE }
    }
    var lat:String? = null
    var long:String? = null

}