package com.bignerdranch.android.knowledgestateexam.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.knowledgestateexam.Item

@Database(entities = [ Item::class ], version = 1, exportSchema = false)
@TypeConverters(ItemTypeConverters::class)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
}