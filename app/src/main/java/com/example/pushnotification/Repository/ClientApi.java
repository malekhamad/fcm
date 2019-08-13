package com.example.pushnotification.Repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi {
    private static Retrofit retrofit;
    private static String baseUrl = "http://10.0.2.2/fcm_project/";

    public static Retrofit getInstance(){
        if(retrofit == null){
            retrofit =new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
