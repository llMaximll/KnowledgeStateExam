package com.bignerdranch.android.knowledgestateexam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class StartFragment : Fragment() {

    private lateinit var startButton: Button

    interface Callbacks {
        fun onStartButton()
    }

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)

        startButton = view.findViewById(R.id.select_item) as Button

        return view
    }

    override fun onStart() {
        super.onStart()

        startButton.setOnClickListener {
            callbacks?.onSelectedItem()
        }
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    companion object {
        fun newInstance(): StartFragment {
            return StartFragment()
        }
    }
}