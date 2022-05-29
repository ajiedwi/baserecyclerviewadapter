package com.ajiedwi.baserecyclerviewadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnFirst: AppCompatButton
    private lateinit var btnSecond: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFirst = findViewById(R.id.btn_to_first_activity)
        btnSecond = findViewById(R.id.btn_to_second_activity)
        btnFirst.setOnClickListener {
            startActivity(
                Intent(this, RecyclerViewAdapterActivity::class.java)
            )
        }
        btnSecond.setOnClickListener {
            startActivity(
                Intent(this, RecyclerViewAdapterWithViewBindingActivity::class.java)
            )
        }
    }
}