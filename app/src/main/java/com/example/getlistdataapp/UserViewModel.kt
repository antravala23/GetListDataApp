package com.example.getlistdataapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.getlistdataapp.model.DataRepository
import com.example.getlistdataapp.model.GetData
import com.example.getlistdataapp.model.GetSubData

class UserViewModel(private val repository: DataRepository): ViewModel() {

    var _result = MutableLiveData<GetData>()

    fun getuserdata(page: Int): LiveData<GetData>{

        _result = repository.getUser(page)

        return _result

    }

}