package com.pjkr.sunnyweather.currentweather.deserializer

import com.google.gson.JsonElement
import com.pjkr.sunnyweather.longterm.model.Properties
import io.realm.RealmList

/**
 * Created by yabol on 28.08.2017.
 */
class WeathersListDeserializer: Deserializer<RealmList<Properties>?> {
    override fun parse(element: JsonElement?): RealmList<Properties>? {
        if(element!!.isJsonArray) {
            var list = RealmList<Properties>()
            var jsonList = element.asJsonArray
            return jsonList.mapTo(list) { PropertyDeserializer().parse(it)!! }
        }
        return null
    }


}