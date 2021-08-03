package com.example.retrofitand3.data.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmApi {
    @GET("api/")
    Call<List<ActivityesModel>> getActivityes ();

    @GET("api/activity/?type=")
    Call<ActivityesModel> getType(@Query("type")String typeId);

    @GET("api/activity/?price=")
    Call<ActivityesModel> getPrice(@Query("price")double price);


}
