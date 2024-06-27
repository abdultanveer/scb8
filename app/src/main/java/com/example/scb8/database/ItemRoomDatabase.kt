package com.example.scb8.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Item::class], version = 1, exportSchema = false)

abstract class ItemRoomDatabase:RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object{  //static in java

        private var INSTANCE: ItemRoomDatabase? = null   //singleton design pattern

        fun getDatabase(context : Context):ItemRoomDatabase{
            return INSTANCE ?: synchronized(this) {    //synchronized block
                val instance = Room.databaseBuilder(context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }        }

        }

