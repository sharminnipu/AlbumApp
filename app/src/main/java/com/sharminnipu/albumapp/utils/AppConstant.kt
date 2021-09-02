package com.sharminnipu.albumapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.sharminnipu.albumapp.model.ImageData

object AppConstant {

    var imageDetails:ImageData?=null
   var albumDefaultImagePath="https://artsmidnorthcoast.com/wp-content/uploads/2014/05/no-image-available-icon-6-300x188.png"

   fun loadImage(context: Context, url: GlideUrl, view: ImageView, defaultImage:Int) {
      Glide.with(context)
         .load(url)
         .placeholder(defaultImage)
         .diskCacheStrategy(DiskCacheStrategy.ALL)
         .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
         .into(view)
   }
}