package com.exodus.exodus;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @GET("trips")
    Call<List<trips_recycler>> getTrips();

    @GET("home_trips")
    Call<List<home_trips>> getHomeTrips();

    @GET("most_going")
    Call<List<home_trips>> getMostGoingTrips();

    @FormUrlEncoded
    @POST("users/")
    Call<ResponseBody> createUser(
            @Field("name") String name,
            @Field("password") String password,
            @Field("e_mail") String email,
            @Field("phone") String phone,
            @Field("city") String city

    );

    @FormUrlEncoded
    @POST("user/login/")
    Call<LoginResponse> UserLogin(
            @Field("e_mail") String email,
            @Field("password") String password
    );


    @FormUrlEncoded
    @PATCH("user/{id}")
    Call<LoginResponse> updateUser(
            @Field("id") int id,
            @Field("name") String name,
            @Field("e_mail") String email,
            @Field("phone") String phone,
            @Field("city") String city
    );

    @FormUrlEncoded
    @PATCH("user/{id}/")
    Call<DefaultResponse> updatePassword(
            @Field("password") String currentPassword,
            @Field("password") String newPassword,
            @Field("id") int id

    );

    @DELETE("user/{id}")
    Call<DefaultResponse> deleteUser(@Path("id") int id);
}