package com.example.scb8

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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
        adapter = RowCardAdapter(data)
        recyclerView.adapter = adapter

    }
}