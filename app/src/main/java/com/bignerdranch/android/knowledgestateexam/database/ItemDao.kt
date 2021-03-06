package com.bignerdranch.android.knowledgestateexam.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bignerdranch.android.knowledgestateexam.Item
import java.util.*

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun getItems(): LiveData<List<Item>>

    @Query("SELECT * FROM item WHERE id=(:id)")
    fun getItem(id: UUID): LiveData<Item?>

    @Query("SELECT * FROM item WHERE itemName=(:itemName)")
    fun getItemName(itemName: String): LiveData<List<Item>>

    @Update
    fun updateItem(item: Item)

    @Insert
    fun addItem(item: Item)
}