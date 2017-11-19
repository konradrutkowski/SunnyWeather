package com.pjkr.sunnyweather.largewidget

import android.annotation.SuppressLint
import android.app.job.JobParameters
import android.app.job.JobService
import android.appwidget.AppWidgetManager
import android.widget.RemoteViews
import com.pjkr.sunnyweather.R
import android.content.ComponentName



/**
 * Created by yabol on 19.11.2017.
 */
class LargeWidgetService : JobService(){
    override fun onStopJob(params: JobParameters?): Boolean {

        return true
    }

    override fun onStartJob(params: JobParameters?): Boolean {

        val widgetIds = params?.extras?.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS)

        if (widgetIds != null) {
            for(singleId in widgetIds){

                val remoteView = RemoteViews(applicationContext?.packageName, R.layout.current_weather_header)
                val theWidget = ComponentName(this, LargeWidgetProvider::class.java!!)
                val manager = AppWidgetManager.getInstance(this)
                manager.updateAppWidget(theWidget, remoteView)
            }
        }
        return true
    }

}