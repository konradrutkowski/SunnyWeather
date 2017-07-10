package com.pjkr.sunnyweather.currentweather.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.pjkr.sunnyweather.R

/**
 * Created by yabol on 10.07.2017.
 */
class CurrentWeatherHeader @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    var background: ImageView? = null
    var textField: TextView? = null

    init {
        View.inflate(context, R.layout.current_weather_header, this)

        background = findViewById(R.id.headerBackground) as ImageView?
        textField = findViewById(R.id.tempText) as TextView?

    }

    fun setImageBackground(drawable : Drawable){
        this.background?.setImageDrawable(drawable)
    }
    fun setTemperature(temperature: Float){
      this.textField?.setText(temperature.toString())
    }
}