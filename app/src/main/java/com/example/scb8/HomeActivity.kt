package com.example.scb8

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scb8.network.MarsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    lateinit var homeTextView: TextView
    lateinit var adapter: RowCardAdapter
    lateinit var recyclerView: RecyclerView

    var data = arrayOf("india","hindi","karnataka","tamilnadu","software")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        homeTextView = findViewById(R.id.tvHome)
        //adapter = RowCardAdapter(data)

    }

    fun getJson(view: View) {
        GlobalScope.launch(Dispatchers.Main) {
            val listResult = MarsApi.retrofitService.getPhotos()
            adapter = RowCardAdapter(listResult)
            recyclerView.adapter = adapter

        }

        }


}