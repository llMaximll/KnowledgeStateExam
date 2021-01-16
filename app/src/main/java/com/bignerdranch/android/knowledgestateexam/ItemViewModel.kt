package com.bignerdranch.android.knowledgestateexam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

class ItemViewModel : ViewModel() {

    private val itemRepository = ItemRepository.get()
    private val itemIdLiveData = MutableLiveData<UUID>()

    val itemLiveData: LiveData<Item?> =
        Transformations.switchMap(itemIdLiveData) { itemId ->
            itemRepository.getItem(itemId)
        }

    fun loadItem(itemId: UUID) {
        itemIdLiveData.value = itemId
    }
}