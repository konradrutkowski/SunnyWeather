package com.pjkr.sunnyweather.longterm.view

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.MenuItemCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.*
import android.widget.Toast
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.data.WeathersRepository
import com.pjkr.sunnyweather.data.local.LocalDataSource
import com.pjkr.sunnyweather.data.remote.RemoteDataSource
import com.pjkr.sunnyweather.longterm.WeatherContract
import com.pjkr.sunnyweather.longterm.model.Properties
import com.pjkr.sunnyweather.longterm.presenter.LongTermWeatherPresenter
import kotlinx.android.synthetic.main.long_term_weather_fragment.*


/**
 * Created by konradrutkowski on 26.06.2017.
 */
class LongTermWeatherFragment : Fragment(), WeatherContract.View {


    override var presenter: WeatherContract.Presenter = LongTermWeatherPresenter(this, WeathersRepository(LocalDataSource, RemoteDataSource))

    lateinit var list: RecyclerView
    lateinit var adapter: LongTermListAdapter
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var searchView: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        adapter = LongTermListAdapter(activity, R.layout.long_term_row)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.long_term_weather_fragment, container, false)
        list = view.findViewById(R.id.weather_list) as RecyclerView
        swipeRefreshLayout = view.findViewById(R.id.swipe_long_term) as SwipeRefreshLayout
        list.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

        list.layoutManager = LinearLayoutManager(context)
        list.adapter = adapter
        initialize()
        return view
    }

    fun initialize() {
        swipeRefreshLayout.setOnRefreshListener { presenter.loadData(getDataToSearch()) }
    }

    fun getDataToSearch() : String{
        if(searchView.query.isNotEmpty()){
            return searchView.query.toString()
        }
        return "London"
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun setAdapter() {
        list.adapter = adapter
    }

    override fun showWeatherList(weatherList: List<Properties>) {
        adapter.changeLongTermWeatherList(weatherList)
    }

    override fun showFailedDataFetch() {
        Toast.makeText(context, "Failed to download the data", Toast.LENGTH_LONG).show()
    }

    @SuppressLint("SetTextI18n")
    override fun showWeather(weather: Weather) {
        city_name_tv?.text = weather.city!!.name
        latlon_tv?.text = weather.city!!.coord!!.lat.toString() + "  " + weather.city!!.coord!!.lon.toString()
        adapter.changeLongTermWeatherList(weather.list!!)
    }

    override fun showLoadIndicator() {
        changeIndicatorVisibility(true)
    }

    override fun hideLoadIndicator() {
        changeIndicatorVisibility(false)
    }

    private fun changeIndicatorVisibility(state: Boolean) {
        activity.runOnUiThread { swipeRefreshLayout.isRefreshing = state }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val manager: SearchManager = activity.applicationContext.getSystemService(Context.SEARCH_SERVICE) as SearchManager

        val menuItem: MenuItem = menu.findItem(R.id.search_longterm)
        searchView = MenuItemCompat.getActionView(menuItem) as SearchView
        searchView.setSearchableInfo(manager.getSearchableInfo(activity.componentName))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.loadData(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        super.onPrepareOptionsMenu(menu)
    }

}