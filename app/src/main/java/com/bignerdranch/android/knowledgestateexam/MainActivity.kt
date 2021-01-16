package com.bignerdranch.android.knowledgestateexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

class MainActivity : AppCompatActivity(),
    StartFragment.Callbacks,
    ChooseModeFragment.Callbacks {

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

    override fun onSelectedMode(itemId: UUID, mode: Boolean) {
        val fragment: Fragment = when (mode) {
            true -> {
                ItemFragment.newInstance(itemId)
            } else -> {
                ItemCreateFragment.newInstance()
            }
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}