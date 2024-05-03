package com.example.potato_pj.API;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController{
    private static String baseURL = "http://gguip7554.cafe24.com/";
    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    static APIService function = retrofit.create(APIService.class);
    static Call<API[]> testCall = function.getData("test");

    public static Call<API[]> getTestCall() {
        return testCall;
    }
}
