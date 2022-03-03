package com.example.getlistdataapp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.getlistdataapp.retrofit.ApiClient
import com.example.getlistdataapp.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {

    val userdata = MutableLiveData<GetData>()

    fun getUser(pc: Int): MutableLiveData<GetData>{

        val apiInterface = ApiClient.buildService().list(pc.toString())

        apiInterface.enqueue( object : Callback<GetData> {
            override fun onResponse(call: Call<GetData>?, response: Response<GetData>?) {

                if(response?.body() != null)
                    userdata.value = response.body()
            }

            override fun onFailure(call: Call<GetData>?, t: Throwable?) {
                Log.e("repository", t.toString())
            }
        })

        return userdata
    }

}