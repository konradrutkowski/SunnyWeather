package com.pjkr.sunnyweather.data.usercity

import android.content.Context
import com.pjkr.sunnyweather.utils.SingletonHolder

/**
 * Created by Konrad Rutkowski on 25.09.2017.
 */
class LocalUserCity private constructor(context: Context) {
    init {
    }

    companion object : SingletonHolder<LocalUserCity, Context>(::LocalUserCity)
}



