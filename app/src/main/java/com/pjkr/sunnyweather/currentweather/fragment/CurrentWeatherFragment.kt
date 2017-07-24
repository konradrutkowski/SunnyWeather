package com.pjkr.sunnyweather.currentweather.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.data.WeatherRepository
import com.pjkr.sunnyweather.currentweather.data.local.WeatherLocalSource
import com.pjkr.sunnyweather.currentweather.data.remote.WeatherRemoteSource
import com.pjkr.sunnyweather.currentweather.presenter.CurrentWeatherPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.current_weather_framgnet.*

/**
 * Created by PJablonski on 26.06.2017.
 */
class CurrentWeatherFragment : Fragment(), CurrentWeatherContract.View {
    var presenter: CurrentWeatherPresenter? = null
    var fragmentBackground: ImageView? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater?.inflate(R.layout.current_weather_framgnet, container, false) as View



        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        this.presenter = CurrentWeatherPresenter(this, WeatherRepository(WeatherRemoteSource(), WeatherLocalSource()))
        Picasso.with(context).load(R.drawable.background).fit().into(background)

    }

    override fun onResume() {
        super.onResume()
        this.presenter?.loadElements("Łódź")
    }

    override fun showLoadingIndicator() {
    }

    override fun hideLoadingIndicator() {
    }

    override fun displayWeathers() {
    }

    override fun showTemperature(temp: String) {
        this.header.setTemperature(context.getString(R.string.temperature, temp))
    }

    override fun showHeaderIcon(iconName: String?) {
        this.header.setWeatherIcon(iconName)
    }

    override fun setPressure(pressure: String?) {
        this.header?.setPressure(pressure)
    }

    override fun setCityName(cityName: String?) {
        this.header?.setCityName(cityName)
    }

    override fun setTemperatureInfo(weatherName: String?, weatherDescription: String?) {
        this.header?.setTemperatureTitle(weatherName)
        this.header?.setTemperatureDescription(weatherDescription)
    }

    override fun setMinTemp(temp: String) {
        this.header?.setMinTemperature(context.getString(R.string.minTemp, temp))
    }

    override fun setMaxTemp(temp: String) {
        this.header?.setMaxTemperature(context.getString(R.string.maxTemp, temp))
    }

}