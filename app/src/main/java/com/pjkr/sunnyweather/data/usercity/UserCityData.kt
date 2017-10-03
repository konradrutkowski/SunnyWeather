package com.pjkr.sunnyweather.data.usercity

import io.realm.RealmObject

/**
 * Created by root on 10.09.2017.
 */

open class UserCityData(var cityName:String = "",
                        var static: Boolean = false
) : RealmObject()