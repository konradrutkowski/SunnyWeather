package com.pjkr.sunnyweather.longterm.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.longterm.WeatherContract
import com.pjkr.sunnyweather.longterm.presenter.LongTermWeatherPresenter

/**
 * Created by konradrutkowski on 26.06.2017.
 */
class LongTermWeatherFragment: Fragment(), WeatherContract.View{


    val presenter: LongTermWeatherPresenter = LongTermWeatherPresenter(this)


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.long_term_weather_fragment, container, false)


        return view
    }

    override fun showTitle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




}