package com.example.scb8

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel

//data = count -- survives the activity recreate after rotation
class MainViewModel: ViewModel() {
    var TAG = MainViewModel::class.java.simpleName

    var _seconds = 0
    var count = 0


    fun startTimer(){
        var timer = object :CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                Log.i(TAG,"time remaining ="+millisUntilFinished)
                _seconds = millisUntilFinished.toInt()
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