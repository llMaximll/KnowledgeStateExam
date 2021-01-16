package com.bignerdranch.android.knowledgestateexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ItemCreateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_item_create, container, false)
    }

    companion object {
        fun newInstance(): ItemCreateFragment {
            return ItemCreateFragment()
        }
    }
}