package com.pjkr.sunnyweather.longterm.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjkr.sunnyweather.longterm.model.Weather

/**
 * Created by konradrutkowski on 28.06.2017.
 */
public class LongTermListAdapter(var viewid: Int) : RecyclerView.Adapter<LongTermHolder>() {

    var longTermWeatherList: List<Weather> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LongTermHolder {
        val view: View = LayoutInflater.from(parent!!.context).inflate(viewid, parent, false)
        return LongTermHolder(view)
    }

    override fun onBindViewHolder(holder: LongTermHolder, position: Int) {
            holder.titleTV.text = longTermWeatherList.get(position).main
    }

    override fun getItemCount(): Int {
        return longTermWeatherList.size
    }


}

