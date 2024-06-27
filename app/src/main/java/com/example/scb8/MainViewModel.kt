package com.example.scb8

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//data = count -- survives the activity recreate after rotation
class MainViewModel: ViewModel() {
    var TAG = MainViewModel::class.java.simpleName

    //i made seconds observable
    var _seconds = MutableLiveData<Int>()
    var count = 0


    fun startTimer(){
        var timer = object :CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                Log.i(TAG,"time remaining ="+millisUntilFinished)
                _seconds.value = millisUntilFinished.toInt()
            }

            override fun onFinish() {
                Log.i(TAG,"completed")
            }
        }.start()
    }

    fun incrementCount(){
        count++
    }
}