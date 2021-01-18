package com.bignerdranch.android.knowledgestateexam

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

private const val ARG_ITEM_ID = "itemId"

class ChooseModeFragment : DialogFragment() {

    interface Callbacks {
        fun onSelectedMode(itemName: String, mode: Boolean)
    }

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val itemName = arguments?.getSerializable(ARG_ITEM_ID) as String

        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
            .setTitle("Mode")
            .setMessage("Choose mode")
            .setPositiveButton("List of available") { _, _ ->
                callbacks?.onSelectedMode(itemName, true)
            }
            .setNegativeButton("Create a new question") { _, _ ->
                callbacks?.onSelectedMode(itemName, false)
            }
            .setNeutralButton("Cancel") { _, _ ->
                // Cancel
            }

        return alertDialog.create()
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    companion object {
        fun newInstance(itemName: String): ChooseModeFragment {
            val args = Bundle().apply {
                putSerializable(ARG_ITEM_ID, itemName)
            }
            return ChooseModeFragment().apply {
                arguments = args
            }
        }
    }
}