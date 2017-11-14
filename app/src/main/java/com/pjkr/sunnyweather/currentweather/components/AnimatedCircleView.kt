package com.pjkr.sunnyweather.currentweather.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.currentweather.components.animations.CircleAnimation
import kotlinx.android.synthetic.main.component_round_border_text_view.view.*

/**
 * Created by yabol on 20.09.2017.
 */
class AnimatedCircleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var rectangle: RectF? = null
    var paint: Paint
    var angle: Float = 0f
    val strokeWidth = 4f
    init {
        val typedAttributes = context.theme.obtainStyledAttributes(attrs, R.styleable.AnimatedCircleView,0, 0)
        try{
            angle = typedAttributes.getFloat(R.styleable.AnimatedCircleView_angle, 0f)
        }finally {
            typedAttributes.recycle()
        }
        paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth

        paint.color = Color.WHITE

        val animation = CircleAnimation(animatedCircle, 360f)
        animation.duration = 1000
        startAnimation(animation)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(rectangle == null){
            rectangle = RectF(strokeWidth, strokeWidth, height - strokeWidth,  height - strokeWidth)
        }
        canvas?.drawArc(rectangle, 0f, angle, false, paint)
    }
}