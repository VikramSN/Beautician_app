package com.v3cube.beautician.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private final static String baseUrl = "http://deshanigc.com/";
    private static Retrofit retro= null;
    private static Gson gson=new GsonBuilder().setLenient().create();

    public Retrofit getRetroData() {
        if(retro==null) {
            retro = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retro;
    }
}
