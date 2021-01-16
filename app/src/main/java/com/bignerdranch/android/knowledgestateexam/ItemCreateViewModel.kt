package com.bignerdranch.android.knowledgestateexam

import androidx.lifecycle.ViewModel

class ItemCreateViewModel : ViewModel() {

    private val itemRepository = ItemRepository.get()

    fun saveItem(item: Item) {
        itemRepository.updateItem(item)
    }

    fun addItem(item: Item) {
        itemRepository.addItem(item)
    }
}