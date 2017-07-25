package com.pjkr.sunnyweather.longterm.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.model.Weather
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
        var property: Properties = longTermWeatherList[position]
        val temp : String = context.getString(R.string.temperature)
        var pressure : String = context.getString(R.string.pressure)
        holder.titleTV.text = temp +" "+ property.temp!!.day.toString()
        holder.descriptionTV.text = pressure +" "+ property.pressure.toString()
        holder.day.text = property.day!! + " "+context.getString(getStringId(property.dayOfTheWeek!!.nameOfTheDay))
        Log.e("Binding", property.icon!!.iconName)
        Picasso.with(context).load(getDrawableId(property.icon!!.iconName)).fit().centerCrop().into(holder.icon)
    }

    fun getDrawableId(name: String): Int{
        return context.resources.getIdentifier(name, "drawable", context.packageName)
    }

    fun getStringId(name: String): Int{
        return context.resources.getIdentifier(name, "string", context.packageName)
    }


    override fun getItemCount(): Int {
        return longTermWeatherList.size
    }

    fun changeLongTermWeatherList(weatherList: List<Properties>) {
        this.longTermWeatherList = weatherList
        this.notifyDataSetChanged()
    }


}
