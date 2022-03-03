package com.example.getlistdataapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.getlistdataapp.model.DataRepository

class UserListViewModelFactory(private val repository: DataRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when(modelClass) {

        UserViewModel::class.java -> UserViewModel(repository)
        else -> throw IllegalArgumentException("Unknown ViewModel class")

//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            return LoginViewModel(
//                loginRepository = LoginRepository(
//                    dataSource = LoginDataSource()
//                )
//            ) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")

    } as T

}