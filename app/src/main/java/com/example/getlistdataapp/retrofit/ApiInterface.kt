package com.example.getlistdataapp.retrofit

import com.example.getlistdataapp.model.GetData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("users")
    fun list(@Query("page")page: String): Call<GetData>

}