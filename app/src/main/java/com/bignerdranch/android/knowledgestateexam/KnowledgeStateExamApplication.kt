package com.bignerdranch.android.knowledgestateexam

import android.app.Application

class KnowledgeStateExamApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ItemRepository.initialize(this)
    }
}