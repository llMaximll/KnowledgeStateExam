package com.bignerdranch.android.knowledgestateexam

import androidx.lifecycle.ViewModel

class ListQuestionsViewModel : ViewModel() {

    private val itemRepository = ItemRepository.get()
    val itemListLiveData = itemRepository.getItemName()
}