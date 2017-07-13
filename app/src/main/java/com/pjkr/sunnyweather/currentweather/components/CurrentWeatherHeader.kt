package com.pjkr.sunnyweather.currentweather.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.pjkr.sunnyweather.R

/**
 * Created by yabol on 10.07.2017.
 */
class CurrentWeatherHeader @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    var weatherIcon: ImageView? = null
    var textField: TextView? = null
    var pressure: TextView? = null
    var cityName: TextView? = null
    var temperatureTitle: TextView? = null
    var temperatureDescription: TextView? = null

    init {
        View.inflate(context, R.layout.current_weather_header, this)

        this.weatherIcon = findViewById(R.id.weatherIcon) as ImageView?
        this.textField = findViewById(R.id.tempText) as TextView?
        this.pressure = findViewById(R.id.pressure) as TextView?
        this.cityName = findViewById(R.id.cityName) as TextView?
        this.temperatureTitle = findViewById(R.id.weatherName) as TextView?
        this.temperatureDescription = findViewById(R.id.weatherDescription) as TextView?

    }
}