package com.sharminnipu.albumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sharminnipu.albumapp.adapter.RecyclerViewAdapter
import com.sharminnipu.albumapp.model.ImageData
import com.sharminnipu.albumapp.utils.AppConstant
import com.sharminnipu.albumapp.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    var count=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViewModel(count)
        previousBtn.setOnClickListener {
            count--
            initViewModel(count)

        }
        nextBtn.setOnClickListener {
            count++
            initViewModel(count)
        }


    }

    private fun initRecyclerView(dataList: List<ImageData>) {

        if(dataList.isEmpty())
        {
            emptyMsg.visibility=View.VISIBLE
        }
        else{

            emptyMsg.visibility=View.GONE
        }

        recyclerViewAdapter= RecyclerViewAdapter(dataList)
        val llm= GridLayoutManager(this,2)
        llm.orientation= GridLayoutManager.VERTICAL
        rvAlbum.layoutManager=llm
        rvAlbum.adapter= recyclerViewAdapter
        recyclerViewAdapter.onItemAction = { model, positon ->
            AppConstant.imageDetails=model
            System.out.println(model)
            val intent = Intent (this, ImagePreviewActivity::class.java)
            startActivity(intent)
        }


    }

    private fun initViewModel(albumIdNo:Int) {
        val viewModel: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it != null) {
                loaderAlbum.visibility=View.GONE
                btnLayout.visibility=View.VISIBLE

                Log.e("listData",it.toString())

                initRecyclerView(it as List<ImageData>)
            } else {
                Toast.makeText(this, "error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.loadListOfData(albumIdNo)


    }



}
