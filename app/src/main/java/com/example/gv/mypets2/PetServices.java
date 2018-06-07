package com.example.gv.mypets2;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PetServices {

    @GET("user/{username}/{password}")
    Call<User> login(@Path("username")String username,@Path("password")String password);

    @POST("user/")
    Call<String> registerAccount(@Body User user);

}
