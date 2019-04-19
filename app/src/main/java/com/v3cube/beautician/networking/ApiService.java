package com.v3cube.beautician.networking;

import com.v3cube.beautician.pojo.DataLogin;
import com.v3cube.beautician.pojo.RegisterData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

//    @GET("eu/index.php/authentication/register")
//    Call<CatPojo> getCatogaryData();

//    @GET("products/")
//    Call<PojoProDetails> getProductData(@Query("prod_id") String productId);

    @FormUrlEncoded
    @POST("eu/index.php/authentication/login")
    Call<DataLogin> sendLoginData(@Field("username") String userName,
                                  @Field("password") String password);

    @FormUrlEncoded
    @POST("eu/index.php/authentication/register")
    Call<RegisterData> sendRegisterData(@Field("first_name") String firstName,
                                        @Field("password") String password,
                                        @Field("email") String email,
                                        @Field("mobile") String mobile,
                                        @Field("last_name") String lastName,
                                        @Field("reference_id") String ref_id);



}
