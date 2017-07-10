package com.pjkr.sunnyweather.currentweather.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
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

    private var borderPaint: Paint = Paint()
    private var tetPaint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas);


        borderPaint.color = Color.parseColor("#F5F5F5")
        borderPaint.strokeWidth = 2F
        borderPaint.style = Paint.Style.STROKE

        tetPaint.color = Color.parseColor("#F5F5F5")

        canvas?.drawCircle((width/2).toFloat(), (height/2).toFloat(), (width/2 - 2).toFloat(), borderPaint)
    }

}