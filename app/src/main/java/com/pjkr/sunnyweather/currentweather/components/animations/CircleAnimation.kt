package com.pjkr.sunnyweather.currentweather.components.animations

import android.view.animation.Animation
import android.view.animation.Transformation
import com.pjkr.sunnyweather.currentweather.CircleBorder
import com.pjkr.sunnyweather.currentweather.components.AnimatedCircleView
import com.pjkr.sunnyweather.currentweather.components.RoundBorderTextView

/**
 * Created by yabol on 17.09.2017.
 */
class CircleAnimation(private var circle: AnimatedCircleView, private var newAngle: Float) : Animation() {


    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        circle.angle = newAngle  * interpolatedTime
        circle.requestLayout()

    }

}