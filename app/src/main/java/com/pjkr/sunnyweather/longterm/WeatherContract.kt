package com.pjkr.sunnyweather.longterm

/**
 * Created by konradrutkowski on 26.06.2017.
 */
interface WeatherContract{

    interface View{
        fun showData()
        fun setAdapter();
    }


    interface Presenter{
        fun loadData()
        fun onStart();

    }



}