package com.bignerdranch.android.knowledgestateexam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

private const val DIALOG_MODE = "DialogDate"

class SelectItemFragment : Fragment() {

    private lateinit var biologyButton: Button
    private lateinit var informaticsButton: Button
    private lateinit var historyButton: Button
    private lateinit var mathematicsButton: Button
    private lateinit var socialStudiesButton: Button
    private lateinit var russianButton: Button
    private lateinit var physicsButton: Button
    private lateinit var chemistryButton: Button
    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        item = Item()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_select_item, container, false)

        biologyButton = view.findViewById(R.id.item_biology)
        informaticsButton = view.findViewById(R.id.item_informatics)
        historyButton = view.findViewById(R.id.item_history)
        mathematicsButton = view.findViewById(R.id.item_mathematics)
        socialStudiesButton = view.findViewById(R.id.item_social_studies)
        russianButton = view.findViewById(R.id.item_russian_language)
        physicsButton = view.findViewById(R.id.item_physics)
        chemistryButton = view.findViewById(R.id.item_chemistry)

        return view
    }

    override fun onStart() {
        super.onStart()

        biologyButton.setOnClickListener {
            ChooseModeFragment.newInstance(0, item.id).apply {
                show(this@SelectItemFragment.requireFragmentManager(), DIALOG_MODE)
            }
        }

        chemistryButton.setOnClickListener {
            Toast.makeText(context, "Chemistry!", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun newInstance(): SelectItemFragment {
            return SelectItemFragment()
        }
    }
}