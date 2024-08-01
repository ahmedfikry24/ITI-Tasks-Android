package com.example.iti_tasks_android

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(
    private val context: Context,
    private val list: List<ItemInfo>
) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount() = list.size
    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = list.size.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =
            convertView ?: inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        val item = view.findViewById<TextView>(android.R.id.text1)
        item.text = list[position].day
        return view
    }
}
