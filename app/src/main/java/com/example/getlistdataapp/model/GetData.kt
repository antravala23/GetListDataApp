package com.example.getlistdataapp.model

data class GetData(
    var page: Int = 0,
    var per_page: Int = 0,
    var total: Int = 0,
    var total_pages: Int = 0,
    var data: ArrayList<GetSubData> = ArrayList()
)