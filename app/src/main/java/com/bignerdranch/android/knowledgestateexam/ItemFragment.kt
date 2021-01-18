package com.bignerdranch.android.knowledgestateexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.util.*

private const val ARG_ITEM_ID = "item_id"

class ItemFragment : Fragment() {

    private lateinit var item: Item
    private lateinit var questionTextView: TextView
    private lateinit var answer1: Button
    private lateinit var answer2: Button
    private lateinit var answer3: Button
    private lateinit var answer4: Button

    private val itemViewModel: ItemViewModel by lazy {
        ViewModelProvider(this).get(ItemViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = Item()
        val itemId = arguments?.getSerializable(ARG_ITEM_ID) as UUID
        itemViewModel.loadItem(itemId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item, container, false)

        questionTextView = view.findViewById(R.id.question)
        answer1 = view.findViewById(R.id.answer_1)
        answer2 = view.findViewById(R.id.answer_2)
        answer3 = view.findViewById(R.id.answer_3)
        answer4 = view.findViewById(R.id.answer_4)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemViewModel.itemLiveData.observe(
            viewLifecycleOwner,
            { item ->
                item?.let {
                    this.item = item
                    updateUI()
                }
            }
        )
    }

    override fun onStart() {
        super.onStart()

        answer1.setOnClickListener {
            when (item.answerInt) {
                1 -> Toast.makeText(
                    context,
                    "True!",
                    Toast.LENGTH_SHORT)
                    .show()
                else -> Toast.makeText(
                    context,
                    "False!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }

        answer2.setOnClickListener {
            when (item.answerInt) {
                2 -> Toast.makeText(
                    context,
                    "True!",
                    Toast.LENGTH_SHORT)
                    .show()
                else -> Toast.makeText(
                    context,
                    "False!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }

        answer3.setOnClickListener {
            when (item.answerInt) {
                3 -> Toast.makeText(
                    context,
                    "True!",
                    Toast.LENGTH_SHORT)
                    .show()
                else -> Toast.makeText(
                    context,
                    "False!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }

        answer4.setOnClickListener {
            when (item.answerInt) {
                4 -> Toast.makeText(
                    context,
                    "True!",
                    Toast.LENGTH_SHORT)
                    .show()
                else -> Toast.makeText(
                    context,
                    "False!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun updateUI() {
        questionTextView.text = item.question
        answer1.text = item.answerString1
        answer2.text = item.answerString2
        answer3.text = item.answerString3
        answer4.text = item.answerString4
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