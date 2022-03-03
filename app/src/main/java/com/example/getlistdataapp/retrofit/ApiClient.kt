package com.example.getlistdataapp.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

//" for demo purpose only https://reqresa.in/api/users?page=1 "

object ApiClient {

    fun buildService(): ApiInterface{

        return Retrofit.Builder()
            .baseUrl("base_url")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiInterface::class.java)

    }

}