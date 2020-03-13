package com.file.Loader.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.file.Loader.R
import com.file.Loader.adapter.ListRecyclerAdapter
import com.file.Loader.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        setupObservers()
        recycler_list?.adapter = ListRecyclerAdapter()
        mViewModel.fetchImageList()
    }

    private fun setupObservers() {
        mViewModel.getImageList().observe(this, Observer {
            loader?.visibility = View.GONE
            val result = it ?: return@Observer
            (recycler_list?.adapter as? ListRecyclerAdapter)?.updateList(result)
        })
    }
}
