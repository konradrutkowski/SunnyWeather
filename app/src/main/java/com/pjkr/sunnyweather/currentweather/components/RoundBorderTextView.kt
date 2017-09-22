package com.pjkr.sunnyweather.currentweather.components

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.pjkr.sunnyweather.R

/**
 * Created by yabol on 03.07.2017.
 */
class RoundBorderTextView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : RelativeLayout(
        context,
        attrs,
        defStyleAttr) {

    init {
        View.inflate(getContext(), R.layout.component_round_border_text_view, this)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}