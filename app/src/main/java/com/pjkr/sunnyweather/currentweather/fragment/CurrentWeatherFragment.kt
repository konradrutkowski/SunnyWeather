package com.pjkr.sunnyweather.currentweather.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.presenter.CurrentWeatherPresenter
import com.pjkr.sunnyweather.data.weather.WeathersRepository
import com.pjkr.sunnyweather.data.weather.local.LocalDataSource
import com.pjkr.sunnyweather.data.weather.remote.RemoteDataSource
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.view.LongTermListAdapter
import com.pjkr.sunnyweather.utils.getColorSecure
import kotlinx.android.synthetic.main.current_weather_fragment.*

/**
 * Created by PJablonski on 26.06.2017.
 */
class CurrentWeatherFragment : Fragment(), CurrentWeatherContract.View {
    private var presenter: CurrentWeatherPresenter? = null
    private var adapter: LongTermListAdapter? = null
    private var list: RecyclerView? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater?.inflate(R.layout.current_weather_fragment, container, false) as View
        this.adapter = LongTermListAdapter(context, R.layout.long_term_row)

        this.list = view.findViewById(R.id.recyclerView) as RecyclerView

        this.list?.adapter = this.adapter
        this.list?.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        this.header?.setBackgroundColor(context.getColorSecure(R.color.colorPrimary))
        this.presenter = CurrentWeatherPresenter(this, WeathersRepository(LocalDataSource, RemoteDataSource))
    }

    override fun onResume() {
        super.onResume()
        this.presenter?.loadCurrentWeather("Łódź")
        this.presenter?.loadNextDaysWeather("Łódź")
    }

    override fun showLoadingIndicator() {
    }

    override fun hideLoadingIndicator() {
    }

    override fun displayWeathers() {
    }

    override fun showTemperature(temp: String) {
        this.header?.setTemperature(context.getString(R.string.temperature_with_degrees, temp))
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

    override fun setWeathersList(weathers: List<Properties>?) {
        if (weathers != null) {
            this.adapter?.changeLongTermWeatherList(weathers)
        }
    }

}