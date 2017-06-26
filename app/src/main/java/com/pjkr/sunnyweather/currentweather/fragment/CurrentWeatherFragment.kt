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

/**
 * Created by PJablonski on 26.06.2017.
 */
class CurrentWeatherFragment : Fragment() {

    var recyclerView?: RecyclerView by bindOptionalView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = inflater?.inflate(R.layout.current_weather_framgnet, container, false) as View

        ButterKnife.bind(this, view)
        return view
    }

    public fun getRecyclerView(){
        return this.recyclerView
    }
}