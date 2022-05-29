package com.ajiedwi.baserecyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajiedwi.baserecyclerviewadapter.R
import com.ajiedwi.baserecyclerviewadapter.adapter.BaseRecyclerViewAdapter

class RecyclerViewAdapterActivity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var btnReset: AppCompatButton
    private lateinit var btnAdd: AppCompatButton
    private lateinit var fruitAdapter: BaseRecyclerViewAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_adapter)

        rv = findViewById(R.id.rv)
        btnReset = findViewById(R.id.btn_reset)
        btnAdd = findViewById(R.id.btn_add)

        fruitAdapter = BaseRecyclerViewAdapter(R.layout.item_recycler_view, false){position, data, view ->
            // init view on recycler view adapter
            val tvNumber = view.findViewById<AppCompatTextView>(R.id.tv_number)
            val tvFruit = view.findViewById<AppCompatTextView>(R.id.tv_fruit)

            // set data to view
            tvNumber.text = "Fruit #${position + 1}"
            tvFruit.text = data
        }

        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv.adapter = fruitAdapter

        btnReset.setOnClickListener {
            resetData()
        }
        btnAdd.setOnClickListener {
            addData()
        }

        resetData()
    }

    private fun resetData(){
        fruitAdapter.setItems(dummyData)
    }

    private fun addData(){
        fruitAdapter.addItems(dummyData)
    }
}