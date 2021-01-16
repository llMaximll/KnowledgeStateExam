package com.bignerdranch.android.knowledgestateexam

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import java.util.*

class ItemCreateFragment : Fragment() {

    interface Callbacks {
        fun onItemChanges(itemId: UUID)
    }

    private val itemCreateViewModel: ItemCreateViewModel by lazy {
        ViewModelProvider(this).get(ItemCreateViewModel::class.java)
    }

    private lateinit var item: Item
    private var callbacks: Callbacks? = null
    private lateinit var addItem: Button
    private lateinit var question: EditText
    private lateinit var answer1: EditText
    private lateinit var answer2: EditText
    private lateinit var answer3: EditText
    private lateinit var answer4: EditText
    private lateinit var answerCount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = Item()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_create, container, false)

        addItem = view.findViewById(R.id.add_item) as Button
        question = view.findViewById(R.id.question) as EditText
        answer1 = view.findViewById(R.id.answer_1) as EditText
        answer2 = view.findViewById(R.id.answer_2) as EditText
        answer3 = view.findViewById(R.id.answer_3) as EditText
        answer4 = view.findViewById(R.id.answer_4) as EditText
        answerCount = view.findViewById(R.id.correct_answer) as EditText

        return view
    }

    override fun onStart() {
        super.onStart()

        val questionWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {

            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int) {
                item.question = sequence.toString()
            }

            override fun afterTextChanged(
                p0: Editable?
            ) {

            }
        }

        question.addTextChangedListener(questionWatcher)

        addItem.setOnClickListener {
            val item = Item()
            item.question = question.text.toString()
            item.answerInt = answerCount.text.toString().toInt()
            item.answerString1 = answer1.text.toString()
            item.answerString2 = answer2.text.toString()
            item.answerString3 = answer3.text.toString()
            item.answerString4 = answer4.text.toString()
            itemCreateViewModel.addItem(item)
            itemCreateViewModel.saveItem(item)
            callbacks?.onItemChanges(item.id)
        }
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    companion object {
        fun newInstance(): ItemCreateFragment {
            return ItemCreateFragment()
        }
    }
}