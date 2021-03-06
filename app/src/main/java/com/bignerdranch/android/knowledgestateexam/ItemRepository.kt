package com.bignerdranch.android.knowledgestateexam

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.bignerdranch.android.knowledgestateexam.database.ItemDatabase
import java.util.*
import java.util.concurrent.Executors

private const val LOG = "ItemRepository"
private const val DATABASE_NAME = "item-databse"

class ItemRepository private constructor(context: Context) {

    private val database: ItemDatabase = Room.databaseBuilder(
        context.applicationContext,
        ItemDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val itemDao = database.itemDao()
    private val executor = Executors.newSingleThreadExecutor() //Создание экземпляра исполнителя

    fun getItems(): LiveData<List<Item>> = itemDao.getItems()

    fun getItem(id: UUID): LiveData<Item?> = itemDao.getItem(id)

    fun getItemName(): LiveData<List<Item>> = itemDao.getItemName(itemName)

    fun updateItem(item: Item) {
        executor.execute {
            itemDao.updateItem(item)
        }
    }

    fun addItem(item: Item) {
        executor.execute {
            itemDao.addItem(item)
        }
    }

    companion object {
        private var INSTANCE: ItemRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = ItemRepository(context)
            }
        }

        fun get(): ItemRepository {
            return INSTANCE ?:
            throw IllegalStateException("ItemRepository must be initialized")
        }

        var itemName: String = ""
    }
}