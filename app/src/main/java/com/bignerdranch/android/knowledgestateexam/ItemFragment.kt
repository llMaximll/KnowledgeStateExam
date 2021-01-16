package com.bignerdranch.android.knowledgestateexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.util.*

private const val ARG_ITEM_ID = "item_id"

class ItemFragment : Fragment() {

    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = Item()
        val itemId = arguments?.getSerializable(ARG_ITEM_ID) as UUID?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item, container, false)

        return view
    }

    companion object {
        fun newInstance(itemId: UUID): ItemFragment {
            val args = Bundle().apply {
                putSerializable(ARG_ITEM_ID, itemId)
            }
            return ItemFragment().apply {
                arguments = args
            }
        }
    }
}