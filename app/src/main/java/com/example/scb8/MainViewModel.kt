package com.example.scb8

import androidx.lifecycle.ViewModel

//data = count -- survives the activity recreate after rotation
class MainViewModel: ViewModel() {
    var count = 0


    fun incrementCount(){
        count++
    }
}