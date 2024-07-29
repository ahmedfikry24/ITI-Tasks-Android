package com.example.iti_tasks_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var phoneNum: AppCompatEditText
    private lateinit var message: AppCompatEditText
    private lateinit var closeButton: AppCompatButton
    private lateinit var nextButton: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        initOnClickListeners()
    }

    private fun initViews() {
        phoneNum = findViewById(R.id.mobile_edit_text)
        message = findViewById(R.id.message_edit_text)
        closeButton = findViewById(R.id.close_button)
        nextButton = findViewById(R.id.next_button)
    }

    private fun initOnClickListeners() {
        closeButton.setOnClickListener {

        }
        nextButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("phone", phoneNum.text.toString())
            intent.putExtra("message", message.text.toString())
            startActivity(intent)
        }
    }
}