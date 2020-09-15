package com.example.mechinetest2.Network;



import com.example.mechinetest2.Network.Model.Mechinetest_model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api_interface {
    public String base_url = "https://www.mocky.io/";




    @GET("v2/5ec39cba300000720039c1f6")
    Call<Mechinetest_model> getResult ();













}
