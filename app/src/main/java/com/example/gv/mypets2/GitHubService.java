package com.example.gv.mypets2;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("user/{username}/{password}")
    Call<User> login(@Path("username")String username,@Path("password")String password);

    @POST("user")

    Call<User>registerAccount(@Body User user);

}
