package com.bignerdranch.android.knowledgestateexam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.util.*

class MainActivity : AppCompatActivity(),
    StartFragment.Callbacks,
    ChooseModeFragment.Callbacks,
    ItemCreateFragment.Callbacks,
    ListQuestionsFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = StartFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }

    override fun onStartButton() {
        val fragment = SelectItemFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onSelectedMode(itemName: String, mode: Boolean) {
        val fragment: Fragment = when (mode) {
            true -> {
                ListQuestionsFragment.newInstance()
            } else -> {
                ItemCreateFragment.newInstance(itemName)
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onItemChanges(itemId: UUID) {
        val fragment = ItemFragment.newInstance(itemId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onListQuestionsSelected(itemId: UUID) {
        val fragment = ItemFragment.newInstance(itemId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}