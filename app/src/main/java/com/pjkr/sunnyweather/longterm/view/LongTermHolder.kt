package com.pjkr.sunnyweather.longterm.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.pjkr.sunnyweather.R

/**
 * Created by konradrutkowski on 28.06.2017.
 */
class LongTermHolder(view: View) : RecyclerView.ViewHolder(view) {

    var titleTV: TextView = view.findViewById(R.id.title_long_term_row) as TextView
    var descriptionTV: TextView = view.findViewById(R.id.description_long_term_row) as TextView
    var day: TextView = view.findViewById(R.id.day_tv) as TextView
    var humidity: TextView = view.findViewById(R.id.humidity_tv) as TextView
    var windSpeed: TextView = view.findViewById(R.id.wind_speed_tv) as TextView
    var icon: ImageView = view.findViewById(R.id.weather_icon_row) as ImageView


}
