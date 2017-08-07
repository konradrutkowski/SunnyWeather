package com.pjkr.sunnyweather.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build

/**
 * Created by yabol on 13.07.2017.
 */
fun Context.getDrawableByName(resourceName: String?): Drawable {
    val resourceId: Int = getDrawableIdByName(resourceName)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        return getDrawable(resourceId)
    }else{
        return getResources().getDrawable(resourceId)
    }
}

fun Context.getDrawableIdByName(resourceName: String?): Int{
    var resources: Resources = this.resources
    return resources.getIdentifier(resourceName, "mipmap", this.packageName)
}