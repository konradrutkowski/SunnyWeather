package com.pjkr.sunnyweather.data.local


import com.pjkr.sunnyweather.currentweather.model.Weather
import com.pjkr.sunnyweather.data.WeathersDataSource
import com.pjkr.sunnyweather.longterm.model.Properties
import io.realm.Realm
import io.realm.RealmList

/**
 * Created by konradrutkowski on 04.07.2017.
 */

object LocalDataSource : WeathersDataSource {

    override fun getTodayForecast(cityName: String, callback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getCurrentWeather(cityName: String, callback: WeathersDataSource.GetWeatherCallback) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val weather = realm.where(Weather::class.java).equalTo("name", cityName).findFirst()
        if(weather != null){
            callback.onSuccess(weather)
        }else{
            callback.onFail()
        }
        realm.commitTransaction()
    }

    override fun getWeatherList(city: String, numberOfDays: String, loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getActivatedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {

    }

    override fun getDeclinedWeathers(loadWeathersCallback: WeathersDataSource.LoadWeathersCallback) {}

    override fun getWeather(city: String, getWeatherCallback: WeathersDataSource.GetWeatherCallback) {
    }

    override fun saveWeather(weather: Weather) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(weather)
        realm.commitTransaction()
    }

    override fun saveLongtermForecast(weathers: RealmList<Properties>) {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(weathers)
        realm.commitTransaction()
    }

    override fun saveCurrentDayForecast(cityName: String, weathers: RealmList<Properties>?) {
        /*val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        var weather = realm.where(Weather::class.java).equalTo("name", cityName).findFirst()
        weather?.list = weathers
        if(weather != null) {
            realm.copyToRealmOrUpdate(weather)
        }
        realm.commitTransaction()*/
    }


}
