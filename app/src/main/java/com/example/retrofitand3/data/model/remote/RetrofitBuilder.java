package com.example.retrofitand3.data.model.remote;

import com.example.retrofitand3.data.model.FilmApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  RetrofitBuilder {

    private RetrofitBuilder(){}

    private static FilmApi instance ;

    public  static  FilmApi getInstance(){
        if (instance ==  null){
            instance = initInstance();
        }
        return  instance ;
    }
    private static FilmApi initInstance(){
        return  new Retrofit.
                Builder().
                baseUrl("https://www.boredapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(FilmApi.class);
    }

}
