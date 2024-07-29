package com.example.iti_tasks_android

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var phoneNum: TextView
    private lateinit var message: TextView
    private lateinit var closeButton: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        initOnClickListeners()
    }


    private fun initViews() {
        phoneNum = findViewById(R.id.num)
        message = findViewById(R.id.message_value)
        closeButton = findViewById(R.id.close_button)
        val intent = intent
        phoneNum.text = intent.getStringExtra("phone")
        message.text = intent.getStringExtra("message")
    }

    private fun initOnClickListeners() {
        closeButton.setOnClickListener {

        }
    }
}