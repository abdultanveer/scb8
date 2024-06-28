package com.example.scb8

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    lateinit var homeTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        homeTextView = findViewById(R.id.tvHome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       var dataReceived =  intent.extras?.getString("mykey")
        homeTextView.setText(dataReceived)
    }

    //http://openweathermap.com/city=bangalore
    fun getWeather(cityName:String):String{
        //query db
        return  "{temp:30, windspeed:45mph}"
    }


    fun anplr(image:String):String{
        //computer vision-- analyse image
        return "ka01-1243"
    }
}