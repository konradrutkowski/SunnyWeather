package com.pjkr.sunnyweather.longterm.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.utils.formatDouble
import com.pjkr.sunnyweather.utils.getDrawableIdByName
import com.pjkr.sunnyweather.utils.getStringIdByName
import com.squareup.picasso.Picasso

/**
 * Created by konradrutkowski on 28.06.2017.
 */
class LongTermListAdapter(var context: Context, var viewid: Int) : RecyclerView.Adapter<LongTermHolder>() {

    var longTermWeatherList: List<Properties> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LongTermHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(viewid, parent, false)
        return LongTermHolder(view)
    }

    override fun onBindViewHolder(holder: LongTermHolder, position: Int) {
        val property: Properties = longTermWeatherList[position]
        holder.titleTV.text = context.getString(R.string.temperature_with_degrees, property.temp!!.day.formatDouble())
        holder.descriptionTV.text = context.getString(R.string.pressure_with_unit, property.pressure.formatDouble())
        holder.day.text = property.day!! + " "+context.getString(context.getStringIdByName(property.dayOfTheWeek!!.nameOfTheDay))
        holder.humidity.text = "Humidity" +" "+ property.humidity.toString()+ " %"
        holder.windSpeed.text = "Wind" +" "+ property.speed.toString()+ " km/h"
        Log.e("Binding", property.icon!!.iconName)
        Picasso.with(context).load(context.getDrawableIdByName(property.icon!!.iconName, "drawable")).fit().centerInside().into(holder.icon)
    }


    override fun getItemCount(): Int {
        return longTermWeatherList.size
    }

    fun changeLongTermWeatherList(weatherList: List<Properties>) {
        this.longTermWeatherList = weatherList
        this.notifyDataSetChanged()
    }


}

