package com.example.scb8

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.scb8.network.MarsApi
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//loosing data on rotation- activity was getting killed and recreated
class MainActivity : AppCompatActivity() {

    lateinit var mainTextView: TextView
    lateinit var viewModel: MainViewModel

    lateinit var constraintLayout: ConstraintLayout
    var TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {  //method header/signature
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        mainTextView = findViewById(R.id.tvMainn)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//whenever seconds value changes please update secondsObserver and owner = this activity -- alive-- register for updates
        //activity has stopped unsubscribe from updates
        viewModel._seconds.observe(this,secondsObserver)
        mainTextView.setText(""+viewModel.count)
        constraintLayout = findViewById(R.id.xmlConstraintLayout)
        Log.i(TAG,"activity is getting created --egg")
        //allocate memory for your activity
    }



    fun clickHandler(view: View) {
            var snackbar:Snackbar = Snackbar.make(constraintLayout,"message deleted",Snackbar.LENGTH_LONG)
                .setAction( "undo",  View.OnClickListener {
                    Log.i("MainActivity","undeleting the mail")
                })
        snackbar.show()
    }

    fun openDialer(view: View) {
        //dialintent = implicit intent
        var dialIntent:Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:987654321"))
        add(10,20)
        //startActivity(dialIntent)
      //  throw NullPointerException("crash demo")
    }

    private fun add(i: Int, i1: Int):Int {
        var d = i *20
        d++
        var f = d*i+i1/20
        d--
        d+=10
        return i * i1

    }

    fun startHome(view: View) {
        //homeintent = explicit intent --since im taking the name of the class to be invoked
        var homeIntent = Intent(this,HomeActivity::class.java)
        homeIntent.putExtra("mykey","currency,jewels")
        startActivity(homeIntent)
    }

    fun incrementCount(view: View) {
        viewModel.startTimer()
        mainTextView.setText(""+viewModel._seconds)
    }

    var secondsObserver:Observer<Int> = object : Observer<Int>{
        override fun onChanged(newValue: Int) {
            mainTextView.setText(""+newValue)
        }

    }

    fun getDataNet(view: View) {
        GlobalScope.launch {
            val listResult = MarsApi.retrofitService.getPhotos()
            Log.i(TAG,"the json received is--\n"+listResult)

        }

    }

}
