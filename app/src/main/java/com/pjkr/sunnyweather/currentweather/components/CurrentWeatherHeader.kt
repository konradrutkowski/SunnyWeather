package com.pjkr.sunnyweather.currentweather.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.utils.getDrawableByName
import com.pjkr.sunnyweather.utils.getDrawableIdByName
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.current_weather_header.view.*

/**
 * Created by yabol on 10.07.2017.
 */
class CurrentWeatherHeader @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    init {
        View.inflate(context, R.layout.current_weather_header, this)
    }

    fun setTemperature(temp: String){
        this.tempText.text = temp
    }

    fun setWeatherIcon(iconName: String?){
        Picasso.with(context).load(context.getDrawableIdByName(iconName)).into(this.weatherIcon)
    }

    fun setPressure(pressure: String?){
        this.pressure.text = context.getString(R.string.pressure, pressure)
    }

    fun setCityName(cityName: String?){
        this.cityName.text = cityName
    }

    fun setTemperatureTitle(title: String?){
        this.weatherName.text = title
    }

    fun setTemperatureDescription(description: String?){
        this.weatherDescription.text = description
    }

    fun setMinTemperature(temperature: String?){
        this.minTemp.text = temperature
    }

    fun setMaxTemperature(temperature: String?){
        this.maxTemp.text = temperature
    }
}