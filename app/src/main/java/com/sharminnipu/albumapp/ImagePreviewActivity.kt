package com.sharminnipu.albumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.sharminnipu.albumapp.model.ImageData
import com.sharminnipu.albumapp.utils.AppConstant
import kotlinx.android.synthetic.main.activity_image_preview.*

class ImagePreviewActivity : AppCompatActivity() {

    lateinit var imageDetailsModel: ImageData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_image_preview)
        setInitialData()
    }


    private  fun setInitialData(){

        imageDetailsModel= AppConstant.imageDetails!!
        tvImageTitle.text=imageDetailsModel.title
        tvAlbumId.text= "Album "+imageDetailsModel.albumId.toString()
        val url= GlideUrl(
            imageDetailsModel.thumbnailUrl,
            LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build())

        AppConstant.loadImage(
            this, url,
            ivPreview,
            R.drawable.blank_img
        )
        ivBack.setOnClickListener {
            finish()
        }
    }
}