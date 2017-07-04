package com.pjkr.sunnyweather.longterm.view

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.longterm.WeatherContract
import com.pjkr.sunnyweather.longterm.presenter.LongTermWeatherPresenter

/**
 * Created by konradrutkowski on 26.06.2017.
 */
class LongTermWeatherFragment : Fragment(), WeatherContract.View {

    val presenter: LongTermWeatherPresenter = LongTermWeatherPresenter(this)

    lateinit var list: RecyclerView
    lateinit var adapter: LongTermListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = LongTermListAdapter(R.id.title_long_term_row)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.long_term_weather_fragment, container, false)
        list = view.findViewById(R.id.weather_list) as RecyclerView
        list.layoutManager = LinearLayoutManager(context)
        list.adapter = adapter
        return view
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun setAdapter() {
        list.adapter = adapter
    }

    override fun showData() {
    }


}