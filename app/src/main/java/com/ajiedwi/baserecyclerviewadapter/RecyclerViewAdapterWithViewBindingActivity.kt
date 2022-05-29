package com.ajiedwi.baserecyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajiedwi.baserecyclerviewadapter.R
import com.ajiedwi.baserecyclerviewadapter.adapter.BaseRecyclerViewAdapter
import com.ajiedwi.baserecyclerviewadapter.databinding.ActivityRecyclerViewAdapterWithViewBindingBinding
import com.ajiedwi.baserecyclerviewadapter.databinding.ItemRecyclerViewBinding

class RecyclerViewAdapterWithViewBindingActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityRecyclerViewAdapterWithViewBindingBinding
    private lateinit var fruitAdapter: BaseRecyclerViewAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRecyclerViewAdapterWithViewBindingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        fruitAdapter = BaseRecyclerViewAdapter(R.layout.item_recycler_view, false){position, data, view ->

            ItemRecyclerViewBinding.bind(view).apply {
                tvNumber.text = "Fruit #${position + 1}"
                tvFruit.text = data
            }

        }

        viewBinding.apply {
            rv.layoutManager = LinearLayoutManager(this@RecyclerViewAdapterWithViewBindingActivity, RecyclerView.VERTICAL, false)
            rv.adapter = fruitAdapter

            btnReset.setOnClickListener {
                resetData()
            }
            btnAdd.setOnClickListener {
                addData()
            }
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