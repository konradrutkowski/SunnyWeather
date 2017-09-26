package com.pjkr.sunnyweather.data.usercity

import io.realm.RealmResults

/**
 * Created by Konrad Rutkowski on 26.09.2017.
 */
interface LoadUserCityCallback {

    fun success(userCityData: RealmResults<UserCityData>)
    fun failed()
}