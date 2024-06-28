package com.example.scb8

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.scb8.network.MarsPhoto

class RowCardAdapter(var data: List<MarsPhoto>) : RecyclerView.Adapter<ReserveCardHolder>() {
    var TAG = RowCardAdapter::class.java.simpleName

    //ajay -- buy row card from market n give it to babu
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReserveCardHolder {
        //LayoutInflater = inflates the baloon-- row_card
        Log.i(TAG,"ajay bought the card")
        var cardBoughtAjay:View = LayoutInflater.from(parent.context).inflate(R.layout.row_card,parent,false)
        return  ReserveCardHolder(cardBoughtAjay)
    }

    //beatriz --keeping count of no of items in the dataset n informs ajay
    override fun getItemCount(): Int {
        Log.i(TAG,"beatriz counted"+data.size)
        return data.size
    }

    //cath - get the card from babu, write the data on the card and insert it in the recyclerview
    override fun onBindViewHolder(cardBoughtAjay: ReserveCardHolder, position: Int) {
        Log.i(TAG,"cath is writing-"+data.get(position))

        cardBoughtAjay.rowTextView.setText(data.get(position).id)
        cardBoughtAjay.rowImage.load(data.get(position).imgSrc)
    }
}

//babu -- keep the card bought by ajay in the reserver card holder
class ReserveCardHolder(cardBoughtAjay:View):RecyclerView.ViewHolder(cardBoughtAjay) {
    var rowTextView:TextView = cardBoughtAjay.findViewById(R.id.tvRowCard)
    var rowImage:ImageView = cardBoughtAjay.findViewById(R.id.ivRowCard)
    init {
        Log.i("ReserveCard","babu got the card from ajay")
    }

}
