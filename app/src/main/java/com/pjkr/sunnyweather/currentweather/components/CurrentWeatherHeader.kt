package com.pjkr.sunnyweather.currentweather.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.utils.getResourceIdByName
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
        Picasso.with(context).load(context.getResourceIdByName(iconName, "mipmap")).into(this.weatherIcon)
    }

    fun setPressure(pressure: String?){
        this.pressure.text = context.getString(R.string.pressure_with_unit, pressure)
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