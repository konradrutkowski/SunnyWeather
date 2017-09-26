package com.pjkr.sunnyweather.data.usercity

import io.realm.Realm

/**
 * Created by Konrad Rutkowski on 25.09.2017.
 */
open class LocalUserCity {
    private var realm: Realm = Realm.getDefaultInstance()

    companion object : LocalUserCity()


    fun save(userCityData: UserCityData) {
        if (realm.where(UserCityData::class.java).equalTo("static", false).findAll().size > 0) {
            realm.copyToRealmOrUpdate(userCityData)
        }
    }

    fun getUserCityData(loadUserCityCallback: LoadUserCityCallback) {
        loadUserCityCallback.success(realm.where(UserCityData::class.java).findAll())
    }
}



