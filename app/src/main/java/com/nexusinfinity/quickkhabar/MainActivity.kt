package com.nexusinfinity.quickkhabar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nexusinfinity.quickkhabar.Adapter.NewsAdapter

class MainActivity : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.setHasFixedSize(true)

        val getItems = fetchData()
        val adapter = NewsAdapter(getItems)
        recyclerView?.adapter = adapter;
    }

    private fun fetchData() : ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 50){
            list.add("Item $i")
        }

        return list
    }
}