package com.example.potato_pj.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("application/api/contents")
    Call<API[]> getData(
            @Query("tableName") String tableName,
            @Query("page") int page,
            @Query("pagingUnit") int pagingUnit
    );
}
