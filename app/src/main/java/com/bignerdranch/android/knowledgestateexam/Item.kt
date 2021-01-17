package com.bignerdranch.android.knowledgestateexam

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Item(@PrimaryKey val id: UUID = UUID.randomUUID(),
                var question: String = "",
                var itemName: String = "",
                var answerString1: String = "",
                var answerString2: String = "",
                var answerString3: String = "",
                var answerString4: String = "",
                var answerInt: Int = 0)