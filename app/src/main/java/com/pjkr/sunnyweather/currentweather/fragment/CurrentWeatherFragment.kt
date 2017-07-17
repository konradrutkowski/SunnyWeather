package com.pjkr.sunnyweather.currentweather.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.currentweather.components.CurrentWeatherHeader
import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.presenter.CurrentWeatherPresenter
import com.pjkr.sunnyweather.currentweather.repository.CurrentWeatherRepository
import com.pjkr.sunnyweather.utils.getDrawableByName
import com.squareup.picasso.Picasso

/**
 * Created by PJablonski on 26.06.2017.
 */
class CurrentWeatherFragment : Fragment(), CurrentWeatherContract.View {
    var presenter: CurrentWeatherPresenter? = null

    var recyclerView: RecyclerView? = null
    var header: CurrentWeatherHeader? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater?.inflate(R.layout.current_weather_framgnet, container, false) as View

        recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView?
        header = view.findViewById(R.id.header) as CurrentWeatherHeader?
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        this.presenter = CurrentWeatherPresenter(this)
        this.presenter?.repository = CurrentWeatherRepository(this.presenter)
    }

    override fun onResume() {
        super.onResume()
        this.presenter?.loadElements("2172797")
    }

    override fun showLoadingIndicator() {
    }

    override fun hideLoadingIndicator() {
    }

    override fun displayWeathers() {
    }

    override fun showTemperature(temp: String) {
        this.header?.setTemperature(context.getString(R.string.temperature, temp))
    }

    override fun showHeaderIcon(iconName: String?) {
        this.header?.setWeatherIcon(iconName)
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