package com.example.pushnotification.Repository;

import com.example.pushnotification.Model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("receive_token.php")
    @FormUrlEncoded
    Call<UserResponse>getCall(@Field("name") String name,@Field("token") String token);

}
