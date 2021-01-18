package com.bignerdranch.android.knowledgestateexam

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

private const val LOG = "ListQuestionsFragment"

class ListQuestionsFragment : Fragment() {

    interface Callbacks {
        fun onListQuestionsSelected(itemId: UUID)
    }

    private var callbacks: Callbacks? = null
    private lateinit var itemRecyclerView: RecyclerView
    private var adapter: ItemAdapter? = ItemAdapter(emptyList())
    private var answerCount = 1

    private val itemListViewModel: ListQuestionsViewModel by lazy {
        ViewModelProvider(this).get(ListQuestionsViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_questions, container, false)

        itemRecyclerView = view.findViewById(R.id.questions_recycler_view)
        itemRecyclerView.layoutManager = LinearLayoutManager(context)
        itemRecyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemListViewModel.itemListLiveData.observe(
            viewLifecycleOwner,
            { items ->
                items?.let {
                    updateUI(items)
                    Log.d(LOG, "updateUI()")
                }
            }
        )
    }

    private fun updateUI(items: List<Item>) {
        adapter = ItemAdapter(items)
        Log.d(LOG, "items = ${items.size}")
        itemRecyclerView.adapter = adapter
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    private inner class ItemHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var item: Item

        private val questionTextView: TextView = itemView.findViewById(R.id.question)
        private val answerTextView: TextView = itemView.findViewById(R.id.answer)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(item: Item) {
            this.item = item
            questionTextView.text = if (this.item.question.length > 50) "${this.item.question.substring(0, 50)}..." else this.item.question
            answerTextView.text = answerCount.toString()
            answerCount++
        }

        override fun onClick(p0: View?) {

            answerCount = 1
            callbacks?.onListQuestionsSelected(item.id)
        }
    }

    private inner class ItemAdapter(var items: List<Item>)
        : RecyclerView.Adapter<ItemHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            val view = layoutInflater.inflate(R.layout.list_item_questions, parent, false)

            return ItemHolder(view)
        }

        override fun getItemCount() = items.size

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            val item = items[position]
            holder.bind(item)
        }
    }

    companion object {
        fun newInstance(): ListQuestionsFragment {
            return ListQuestionsFragment()
        }
    }
}