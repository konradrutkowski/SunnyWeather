package com.pjkr.sunnyweather.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by yabol on 31.08.2017.
 */
fun Calendar.fromString(timeString: String){
   val timeFormat = SimpleDateFormat("yyyy-MM-dd")
   this.time = timeFormat.parse(timeString)
}