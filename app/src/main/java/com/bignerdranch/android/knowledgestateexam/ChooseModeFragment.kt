package com.bignerdranch.android.knowledgestateexam

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*


private const val ARG_MODE = "mode"
private const val ARG_ITEM_ID = "itemId"

class ChooseModeFragment : DialogFragment() {

    interface Callbacks {
        fun onSelectedMode(itemId: UUID, mode: Boolean)
    }

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val itemId = arguments?.getSerializable(ARG_ITEM_ID) as UUID

        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
            .setTitle("Mode")
            .setMessage("Choose mode")
            .setPositiveButton("Yes") { _, _ ->
                callbacks?.onSelectedMode(itemId, true)
            }
            .setNegativeButton("No") { _, _ ->
                callbacks?.onSelectedMode(itemId, false)
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
        fun newInstance(itemCount: Int, itemId: UUID): ChooseModeFragment {
            val args = Bundle().apply {
                putSerializable(ARG_MODE, itemCount)
                putSerializable(ARG_ITEM_ID, itemId)
            }
            return ChooseModeFragment().apply {
                arguments = args
            }
        }
    }
}