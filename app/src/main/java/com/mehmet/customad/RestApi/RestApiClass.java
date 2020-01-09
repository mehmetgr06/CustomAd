package com.mehmet.customad.RestApi;

import com.mehmet.customad.Models.AdImagePojo;
import com.mehmet.customad.Models.LoginPojo;
import com.mehmet.customad.Models.RegisterPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApiClass {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginPojo> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterPojo> register(@Field("email")String email, @Field("password") String password);

    @GET("get_ad_images.php")
    Call<AdImagePojo> get_ad_image(@Query("gender") String gender,
                                   @Query("age") String age,
                                   @Query("category") String category);

}
