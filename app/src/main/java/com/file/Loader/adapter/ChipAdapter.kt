package com.file.Loader.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.file.Loader.R
import com.file.Loader.model.Category

class ChipAdapter : RecyclerView.Adapter<ChipAdapter.ViewHolder>() {

    private val mList: MutableList<Category> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.flex_item, parent, false))

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(mList[position])
    }

    fun updateList(categories: List<Category>?) {
        categories?.let {
            mList.clear()
            mList.addAll(it)
            notifyDataSetChanged()
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(category: Category) {
            itemView.findViewById<TextView?>(R.id.item)?.text = category?.title
        }

    }
}