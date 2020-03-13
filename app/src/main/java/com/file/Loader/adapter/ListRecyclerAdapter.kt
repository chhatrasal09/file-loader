package com.file.Loader.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.file.Loader.R
import com.file.Loader.model.PasteBinDataResponse
import com.file.Loader.utils.Utility
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import java.util.ArrayList

class ListRecyclerAdapter : RecyclerView.Adapter<ListRecyclerAdapter.ViewHolder>() {

    private val mList: MutableList<PasteBinDataResponse> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.list_row_item, parent, false)
        )

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(mList[position])
    }

    fun updateList(result: ArrayList<PasteBinDataResponse>) {
        mList.clear()
        mList.addAll(result)
        notifyDataSetChanged()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindViewHolder(pasteBinDataResponse: PasteBinDataResponse) {
            itemView.findViewById<TextView?>(R.id.profile_name)?.text =
                "${pasteBinDataResponse.likes} likes"
            itemView.findViewById<TextView?>(R.id.profile_name)?.text =
                pasteBinDataResponse.user?.name
            itemView.findViewById<ImageView?>(R.id.like_image)
                ?.setImageDrawable(
                    if (!pasteBinDataResponse.liked_by_user) {
                        ContextCompat.getDrawable(itemView.context, R.drawable.ic_like)
                    } else {
                        Utility.getColouredDrawable(
                            itemView.context,
                            R.drawable.ic_like,
                            ContextCompat.getColor(itemView.context, R.color.colorAccent)
                        )
                    }
                )
            Glide.with(itemView.context)
                .load(pasteBinDataResponse.urls?.thumb)
                .into(itemView.findViewById(R.id.image_view))
            Glide.with(itemView.context)
                .load(pasteBinDataResponse.user?.profile_image?.small)
                .into(itemView.findViewById(R.id.profile_image))

            itemView.findViewById<RecyclerView?>(R.id.categories_list)?.apply {
                layoutManager = FlexboxLayoutManager(itemView.context).also {
                    it.flexDirection = FlexDirection.ROW
                }
                adapter = ChipAdapter().also {
                    it.updateList(pasteBinDataResponse.categories)
                }
            }
        }
    }
}