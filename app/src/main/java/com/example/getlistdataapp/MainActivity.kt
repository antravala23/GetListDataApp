package com.example.getlistdataapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getlistdataapp.databinding.ActivityMainBinding
import com.example.getlistdataapp.model.DataRepository
import com.example.getlistdataapp.model.GetSubData

class MainActivity : AppCompatActivity() {

    private lateinit var loginViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: UserListAdapter

    companion object {
        var count = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = binding.mainRvList
        val edtSearch = binding.mainSearch
        val scroolview = binding.nestedList
        val progress = binding.progressBar

        list.isNestedScrollingEnabled = false

        scroolview.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            // on scroll change we are checking when users scroll as bottom.
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                // in this method we are incrementing page number,
                // making progress bar visible and calling get data method.
                count++
                // on below line we are making our progress bar visible.
                progress.visibility = View.VISIBLE
                if (count <= 2) {
                    // on below line we are again calling
                    // a method to load data in our array list.
                    progress.visibility = View.GONE
                    displayUsersList(count)
                } else {
                    progress.visibility = View.GONE
                }
            }
        })

        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                // TODO Auto-generated method stub
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {

                // filter your list from your input
                filter(s.toString())
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        })

        loginViewModel =
            ViewModelProvider(
                this, UserListViewModelFactory(
                    DataRepository()
                )
            )[UserViewModel::class.java]

        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        adapter = UserListAdapter(it.data)
//        binding.mainRvList.adapter = adapter

        displayUsersList(1)

    }

    fun displayUsersList(page: Int) {

        loginViewModel.getuserdata(page).observe(this, {

            adapter = UserListAdapter(it.data)
            binding.mainRvList.adapter = adapter
        })

    }

    fun filter(text: String?) {
        val temp: MutableList<GetSubData> = ArrayList()
        for (d in loginViewModel._result.value!!.data) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.first_name.contains(text!!) || d.last_name.contains(text)
                || d.email.contains(text)
            ) {
                temp.add(d)
            }
        }
        //update recyclerview
        adapter = UserListAdapter(temp)
        binding.mainRvList.adapter = adapter
    }

}