package com.pjkr.sunnyweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.pjkr.sunnyweather.currentweather.fragment.CurrentWeatherFragment
import com.pjkr.sunnyweather.longterm.view.LongTermWeatherFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_component.view.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentWeatherTab.tabName.text = getString(R.string.current_tab)
        longTermTab.tabName.text = getString(R.string.long_term_tab)

        currentWeatherTab.tabName.setOnClickListener { startCurrentWeatherFragment() }
        longTermTab.tabName.setOnClickListener { startLongTermWeatherFragment() }

        if (savedInstanceState == null) {
            startCurrentWeatherFragment()
        }
    }

    private fun startCurrentWeatherFragment(){
        currentWeatherTab.showUnderline()
        longTermTab.hideUnderline()
        startFragment(R.id.container, CurrentWeatherFragment(), true, false, null)
    }

    private fun startLongTermWeatherFragment(){
        currentWeatherTab.hideUnderline()
        longTermTab.showUnderline()
        startFragment(R.id.container, LongTermWeatherFragment(), true, false, null)
    }


}
