package com.pjkr.sunnyweather.largewidget

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle

/**
 * Created by yabol on 19.11.2017.
 */
class LargeWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        val widget = ComponentName(context, LargeWidgetProvider::class.java)

        val allWidgetIds = appWidgetManager?.getAppWidgetIds(widget)

        val widgetService = ComponentName(context, LargeWidgetService::class.java)

        val extras = PersistableBundle()
        extras.putIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS, allWidgetIds)

        val jobBuilder = JobInfo.Builder(0, widgetService)
        jobBuilder.setMinimumLatency(1)
        jobBuilder.setOverrideDeadline(3 * 1000)
        jobBuilder.setExtras(extras)

        val jobScheduler = context?.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(jobBuilder.build())
    }
}