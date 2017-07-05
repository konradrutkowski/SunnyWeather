package com.pjkr.sunnyweather.longterm.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.pjkr.sunnyweather.R
import org.w3c.dom.Text

/**
 * Created by konradrutkowski on 28.06.2017.
 */
class LongTermHolder(view: View) : RecyclerView.ViewHolder(view) {

    var titleTV: TextView = view.findViewById(R.id.title_long_term_row) as TextView
    var descriptionTV: TextView = view.findViewById(R.id.description_long_term_row) as TextView

}
