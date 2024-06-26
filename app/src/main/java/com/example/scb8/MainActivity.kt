package com.example.scb8

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var constraintLayout: ConstraintLayout
    var TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.xmlConstraintLayout)
        Log.i(TAG,"activity is getting created --egg")
        //allocate memory for your activity
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"activity is getting started[visible click] --egg hatched")
        //fetch the data while the user is interacting with ur app
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"activity resumed- visible again --woken")
        //restore the state of nfs app
    }

    override fun onPause() {
        super.onPause()
        Log.v(TAG,"activity paused- invisible --sleeping")
        //save the state of the nfs app

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"activity stopped- hibernate --death")
        //release the resources
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"activity destroyed- purged --no remains of hen")

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
        startActivity(dialIntent)
        throw NullPointerException("crash demo")
    }

    fun startHome(view: View) {
        //homeintent = explicit intent --since im taking the name of the class to be invoked
        var homeIntent = Intent(this,HomeActivity::class.java)
        homeIntent.putExtra("mykey","currency,jewels")
        startActivity(homeIntent)
    }
}