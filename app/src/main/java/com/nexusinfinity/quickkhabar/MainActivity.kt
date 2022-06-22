package com.nexusinfinity.quickkhabar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nexusinfinity.quickkhabar.Adapter.NewsAdapter
import com.nexusinfinity.quickkhabar.Adapter.OnItemClicked

class MainActivity : AppCompatActivity(), OnItemClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val getItems = fetchData()
        val adapter = NewsAdapter(getItems, this)
        recyclerView.adapter = adapter;
    }

    private fun fetchData() : ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 50){
            list.add("Item $i")
        }

        return list
    }

    override fun onClicked(text: String) {
        Toast.makeText(this, "Item clicked is: $text", Toast.LENGTH_SHORT).show()
    }
}