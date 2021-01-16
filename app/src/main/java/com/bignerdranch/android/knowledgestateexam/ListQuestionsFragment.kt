package com.bignerdranch.android.knowledgestateexam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListQuestionsFragment : Fragment() {

    private lateinit var itemRecyclerView: RecyclerView
    private var adapter: ItemAdapter? = ItemAdapter(emptyList())

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

    private inner class ItemHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var item: Item

        override fun onClick(p0: View?) {

        }
    }

    private inner class ItemAdapter(var items: List<Item>)
        : RecyclerView.Adapter<ItemHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        }

        override fun getItemCount(): Int {

        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        }
    }
}