package com.pjkr.sunnyweather.currentweather

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * Created by yabol on 17.09.2017.
 */
class CircleBorder @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var angle = 0f
    var rectangle: RectF
    var paint: Paint

    init {
        val strokeWidth : Float = 40f
        paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth

        paint.color = Color.WHITE

        rectangle = RectF(strokeWidth, strokeWidth,  width / 2 + strokeWidth, width / 2 + strokeWidth)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawArc(rectangle, 0f, angle, false, paint)
    }
}