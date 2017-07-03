package com.pjkr.sunnyweather.currentweather.components

import android.content.Context
import android.graphics.Canvas
import android.support.v4.widget.TextViewCompat
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by yabol on 03.07.2017.
 */
class RoundBorderTextView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : TextView(
        context,
        attrs,
        defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}