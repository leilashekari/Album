package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class GalleryAdapter (val list: List<PictureUiModel>) : RecyclerView.Adapter<GalleryAdapter.PictureViewHolder>() {

    class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var pictureIv: ImageView = itemView.findViewById(R.id.pictureIv)
        var titleTv: TextView = itemView.findViewById(R.id.titleTv)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_picture ,parent ,false)
        return PictureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val pictureUiModel = list[position]
        val url = pictureUiModel.url
        val author = pictureUiModel.author

        Picasso.get().load(url).into(holder.pictureIv)
        holder.titleTv.text = author

    }
}