package com.example.scb8.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val itemName: String,
    val itemPrice: Double,
    val quantityInStock: Int

    )

