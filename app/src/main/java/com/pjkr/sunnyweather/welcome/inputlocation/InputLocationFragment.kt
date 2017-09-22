package com.pjkr.sunnyweather.welcome.inputlocation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pjkr.sunnyweather.R
import com.pjkr.sunnyweather.data.usercity.UserCityData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.add_new_city_fragment_layout.*

/**
 * Created by Konrad Rutkowski on 22.09.2017.
 */
class InputLocationFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.add_new_city_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.with(activity).load(R.drawable.gps_user_100x100).fit().centerCrop().into(add_location_picture)
    }

    fun addUserCity() {
        UserCityData(textCityInput.text.toString(), true)
    }
}