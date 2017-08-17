package com.pjkr.sunnyweather.components

import android.content.Context
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.view.View
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.utils.getColorSecure
import kotlinx.android.synthetic.main.tab_component.view.*

/**
 * Created by yabol on 16.08.2017.
 */
class TabElement @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.tab_component, this)
    }

    fun hideUnderline(){
        this.underline.setBackgroundColor(context.getColorSecure(R.color.colorPrimary))
    }

    fun showUnderline(){
        this.underline.setBackgroundColor(context.getColorSecure(R.color.colorAccent))
    }
}