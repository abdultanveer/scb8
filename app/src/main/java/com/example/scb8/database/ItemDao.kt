package com.example.scb8.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Insert                                  //insert into item where values(groceryitem.id
    suspend fun insert(groceryItem: Item)

    @Query("SELECT * from item WHERE id = :itemId")
    fun getItem(itemId: Int): Flow<Item>

    @Query("SELECT * from item ORDER BY itemName ASC")

    fun getItems(): Flow<List<Item>>

    @Update
    suspend   fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

}