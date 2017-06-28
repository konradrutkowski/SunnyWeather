package com.pjkr.sunnyweather.currentweather.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.currentweather.contract.CurrentWeatherContract
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.currentweather.presenter.CurrentWeatherPresenter

/**
 * Created by PJablonski on 26.06.2017.
 */
class CurrentWeatherFragment : Fragment(), CurrentWeatherContract.View {
    var presenter: CurrentWeatherPresenter? = null
    @BindView(R.id.recyclerView)
    var recyclerView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater?.inflate(R.layout.current_weather_framgnet, container, false) as View

        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        this.presenter = CurrentWeatherPresenter(this)
        this.presenter?.repository
    }

    override fun displayWeather(weather: Weather) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingIndicator() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingIndicator() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayWeathers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}