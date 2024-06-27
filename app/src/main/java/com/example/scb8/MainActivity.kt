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
import androidx.room.Dao
import com.example.scb8.database.Item
import com.example.scb8.database.ItemDao
import com.example.scb8.database.ItemRoomDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var dao: ItemDao
    lateinit var constraintLayout: ConstraintLayout
    var TAG = MainActivity::class.java.simpleName
    lateinit var mainTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        mainTextView = findViewById(R.id.tvMain)
        constraintLayout = findViewById(R.id.xmlConstraintLayout)
        Log.i(TAG,"activity is getting created --egg")
        //allocate memory for your activity

        var  database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

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

    fun insertItemDb(view: View) {
        var item = Item(777,"fruits",999.0,88)
        insertDb(item)
    }

    private fun insertDb(item: Item) {
        //coroutines - async api
        GlobalScope.launch {
            dao.insert(item)
        }
    }

    fun findItem(view: View) {
        GlobalScope.launch(Dispatchers.Main) {
            var item = dao.getItem(777)
            mainTextView.setText(item.first().itemName)
        }
    }
}