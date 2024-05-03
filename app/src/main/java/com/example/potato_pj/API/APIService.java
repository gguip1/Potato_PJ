package com.example.potato_pj.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
    @GET("application/api/{test}")
    Call<API[]> getData(@Path("test") String test);
}
