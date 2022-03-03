package com.example.getlistdataapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getlistdataapp.model.GetData
import com.example.getlistdataapp.model.GetSubData
import com.squareup.picasso.Picasso

class UserListAdapter(private val usersList: List<GetSubData>) :
    RecyclerView.Adapter<MyviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.list_item,
                    parent,
                    false
                )

        return MyviewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.textViewFName!!.text = usersList[position].first_name
        holder.textViewLName!!.text = usersList[position].last_name
        holder.textViewEmail!!.text = usersList[position].email

        holder.textViewImage!!.setOnClickListener {
            Picasso.get().load(usersList[position].avatar).into(holder.textViewImage)
        }

    }
}

class MyviewHolder : RecyclerView.ViewHolder {

    var textViewFName: TextView? = null
    var textViewLName: TextView? = null
    var textViewEmail: TextView? = null
    var textViewImage: ImageView? = null

    constructor(user: View) : super(user) {
        textViewImage = user.findViewById(R.id.image)
        textViewFName = user.findViewById(R.id.fname)
        textViewLName = user.findViewById(R.id.lname)
        textViewEmail = user.findViewById(R.id.email)
    }

}