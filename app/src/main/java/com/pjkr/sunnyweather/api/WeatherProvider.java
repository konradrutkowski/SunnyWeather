package com.pjkr.sunnyweather.api;


import com.pjkr.sunnyweather.longterm.model.Weather;

import java.util.List;
import java.util.ServiceConfigurationError;

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
        mapAPI.getMovie("London", "7", "3a6092b5c20245c7b5b76a920b2d9208", new Callback<List<Weather>>() {


            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                response.toString();
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                t.printStackTrace();
            }
        });
        // List<Weather> weatherList = ServiceGenerator.createService(TaskService.class);

    }
}
