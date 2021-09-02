package com.sharminnipu.albumapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.sharminnipu.albumapp.R
import com.sharminnipu.albumapp.model.ImageData
import com.sharminnipu.albumapp.utils.AppConstant.loadImage
import kotlinx.android.synthetic.main.raw_album_view.view.*

class RecyclerViewAdapter( val dataList: List<ImageData> ): RecyclerView.Adapter<RecyclerViewAdapter.FeedViewHolder>(){


    var onItemAction: ((model:ImageData,position: Int) -> Unit)? = null


    var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.FeedViewHolder {
        context = parent.context
        return FeedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.raw_album_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerViewAdapter.FeedViewHolder, position: Int) {
        val model = dataList[position]

        holder.run {
            val url=GlideUrl(
                model.thumbnailUrl,
                LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                  .build())
            tvTitle.text="Album "+ model.albumId.toString()
              loadImage(
                  context!!, url,
                  ivPhoto,
                  R.drawable.blank_img
              )

            holder.itemView.setOnClickListener {
                val model=dataList[position]
                onItemAction?.invoke(model,position)
            }


        }


    }


    inner class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle = view.tvAlbumId
        val ivPhoto = view.ivAlbumImg


    }



}