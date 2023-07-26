package com.example.proyectoieca

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class GridAdapter(private val context: Context, private val pptItems: List<PptItem>) : BaseAdapter() {

    override fun getCount(): Int {
        return pptItems.size
    }

    override fun getItem(position: Int): Any {
        return pptItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val pptItem = pptItems[position]
        viewHolder.pptTitleTextView.text = pptItem.pptTitle

        view.setOnClickListener {
            val pptUrl = pptItem.pptUrl
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(pptUrl)
            context.startActivity(intent)
        }

        return view
    }

    private class ViewHolder(view: View) {
        val pptTitleTextView: TextView = view.findViewById(R.id.pptTitleTextView)
    }
}