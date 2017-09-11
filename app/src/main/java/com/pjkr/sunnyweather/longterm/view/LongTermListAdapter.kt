package com.pjkr.sunnyweather.longterm.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.utils.*
import com.squareup.picasso.Picasso

/**
 * Created by konradrutkowski on 28.06.2017.
 */
class LongTermListAdapter(var context: Context, var viewid: Int) : RecyclerView.Adapter<LongTermHolder>() {

    var longTermWeatherList: List<Weather> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LongTermHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(viewid, parent, false)
        return LongTermHolder(view)
    }

    override fun onBindViewHolder(holder: LongTermHolder, position: Int) {
        val weather = longTermWeatherList[position]
        holder.titleTV.text = context.getString(R.string.temperature_with_degrees, weather.data!!.temp.formatDouble())
        holder.descriptionTV.text = context.getString(R.string.pressure_with_unit, weather.data!!.pressure.toString())
        holder.day.text = weather.timeString!! + " "+context.getString(context.getResourceIdByName(weather.dayOfTheWeek!!.nameOfTheDay, "string"))
        holder.humidity.text = "Humidity" +" "+ weather.data?.humidity.toString() + " %"
        holder.windSpeed.text = "Wind" +" "+ weather.wind?.speed.toString() + " km/h"
        Picasso.with(context).load(context.getResourceIdByName(weather.listIcon!!.iconName, "drawable")).fit().centerInside().into(holder.icon)
    }


    override fun getItemCount(): Int {
        return longTermWeatherList.size
    }

    fun changeLongTermWeatherList(weatherList: List<Weather>?){
        if(weatherList != null) {
            this.longTermWeatherList = weatherList
        }
    }

}

