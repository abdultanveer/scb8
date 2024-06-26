package com.example.scb8

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        constraintLayout = findViewById(R.id.xmlConstraintLayout)

    }

    fun clickHandler(view: View) {
            var snackbar:Snackbar = Snackbar.make(constraintLayout,"message deleted",Snackbar.LENGTH_LONG)
                .setAction( "undo",  View.OnClickListener {
                    Log.i("MainActivity","undeleting the mail")
                })
        snackbar.show()
    }
}