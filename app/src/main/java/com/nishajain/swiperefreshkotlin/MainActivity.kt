package com.nishajain.swiperefreshkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        val swipe = findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)

        // Used for vertical linearlayout view
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class RecyclerModel
        val data = ArrayList<RecyclerModel>()

        // This loop will create 12 Views containing
        // the image with the count of view
        for (i in (1..12)) {
            val no = (1..12).random()
            data.add(RecyclerModel(R.drawable.ic_launcher_background, "Android " + no))
        }

        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            val adapter = RecyclerAdapter(data)
            recyclerview.adapter = adapter
            Toast.makeText(this, "Data Refreshed", Toast.LENGTH_SHORT).show()
        }
        // This will pass the ArrayList to our Adapter
        val adapter = RecyclerAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}