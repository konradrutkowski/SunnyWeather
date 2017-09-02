package com.pjkr.sunnyweather

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.pjkr.sunnyweather.currentweather.fragment.CurrentWeatherFragment
import com.pjkr.sunnyweather.longterm.view.LongTermWeatherFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_component.view.*

class MainActivity : AppCompatActivity() {
    private companion object {
        const val CURRENT_TAB = 0
        const val LONG_TERM_TAB = 1
        const val TAB = "TAB"
    }
    private var selectedTab: Int = CURRENT_TAB;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentWeatherTab.tabName.text = getString(R.string.current_tab)
        longTermTab.tabName.text = getString(R.string.long_term_tab)

        currentWeatherTab.tabName.setOnClickListener { startCurrentWeatherFragment() }
        longTermTab.tabName.setOnClickListener { startLongTermWeatherFragment() }

        Log.e("OnCreate", "executed " + selectedTab)
        if (savedInstanceState == null) {
            startCurrentWeatherFragment()
        }else{
            selectedTab = savedInstanceState.getInt(TAB)
            Log.e("OnCreate", "recreate " + selectedTab)
            displayTabUnderline()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(TAB, selectedTab)
    }

    private fun startCurrentWeatherFragment(){
        selectedTab = CURRENT_TAB
        displayTabUnderline()
        startFragment(R.id.container, CurrentWeatherFragment(), true, false, null)
    }

    private fun startLongTermWeatherFragment(){
        selectedTab = LONG_TERM_TAB
        displayTabUnderline()
        startFragment(R.id.container, LongTermWeatherFragment(), true, false, null)
    }

    private fun displayTabUnderline(){
        if(selectedTab == 0){
            currentWeatherTab.showUnderline()
            longTermTab.hideUnderline()
        }else{
            currentWeatherTab.hideUnderline()
            longTermTab.showUnderline()
        }
    }


}
