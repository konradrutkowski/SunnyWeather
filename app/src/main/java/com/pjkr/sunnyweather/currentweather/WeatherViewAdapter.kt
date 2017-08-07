package com.pjkr.sunnyweather.currentweather

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.viewholder.AbstractViewHolder

/**
 * Created by PJablonski on 28.06.2017.
 */
class WeatherViewAdapter(provider: CurrentWeatherContract.Provider): RecyclerView.Adapter<AbstractViewHolder>() {
    private var provider: CurrentWeatherContract.Provider = provider

    override fun getItemCount(): Int {
        return provider.getCount()
    }

    override fun onBindViewHolder(holder: AbstractViewHolder?, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AbstractViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}