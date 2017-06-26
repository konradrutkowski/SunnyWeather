package com.pjkr.sunnyweather.longterm

/**
 * Created by konradrutkowski on 26.06.2017.
 */
interface WeatherContract{

    interface View{
        fun showTitle()
    }
    interface Presenter{
        fun loadData()

    }



}