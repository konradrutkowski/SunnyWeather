package com.pjkr.sunnyweather.api;


import android.support.annotation.NonNull;
import android.util.Log;

import com.pjkr.sunnyweather.longterm.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by konradrutkowski on 28.06.2017.
 */

public class WeatherProvider {
    public static final String BASE_URL = "http://api.myservice.com/";


    public void getWeather() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        MapAPI mapAPI = retrofit.create(MapAPI.class);
        mapAPI.getWeather("London", "7", "3a6092b5c20245c7b5b76a920b2d9208", new Callback<List<Weather>>() {


            @Override
            public void onResponse(@NonNull Call<List<Weather>> call, @NonNull Response<List<Weather>> response) {
                Log.e("Request", " call Value = "+call.toString());
                Log.e("Request", " Value = "+response.toString());

            }

            @Override
            public void onFailure(@NonNull Call<List<Weather>> call, @NonNull Throwable t) {
                Log.e("Request", " Value = "+call.toString());
                t.printStackTrace();
            }
        });
        // List<Weather> weatherList = ServiceGenerator.createService(TaskService.class);

    }
}
