package com.example.iti_tasks_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var firstShape: LinearLayout
    private lateinit var secondShape: LinearLayout
    private lateinit var thirdShape: LinearLayout
    private lateinit var fourthShape: LinearLayout
    private lateinit var fifthShape: LinearLayout
    private lateinit var firstButton: AppCompatButton
    private lateinit var secondButton: AppCompatButton
    private lateinit var thirdButton: AppCompatButton
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
        firstShape = findViewById(R.id.first_linear)
        secondShape = findViewById(R.id.second_linear)
        thirdShape = findViewById(R.id.third_linear)
        fourthShape = findViewById(R.id.fourth_linear)
        fifthShape = findViewById(R.id.fifth_linear)
        firstButton = findViewById(R.id.first_button)
        secondButton = findViewById(R.id.second_button)
        thirdButton = findViewById(R.id.third_button)
    }

    private fun initOnClickListeners() {
        var thirdShapeColor = R.color.blue
        var fourthShapeColor = R.color.orange
        var fifthShapeColor = R.color.green
        firstShape.setOnClickListener {
            firstShape.background = getDrawable(R.color.purple)
        }
        secondShape.setOnClickListener {
            secondShape.background = getDrawable(R.color.black)
        }
        thirdShape.setOnClickListener {
            thirdShape.background = getDrawable(thirdShapeColor)
        }
        fourthShape.setOnClickListener {
            fourthShape.background = getDrawable(fourthShapeColor)
        }
        fifthShape.setOnClickListener {
            fifthShape.background = getDrawable(fifthShapeColor)
        }
        firstButton.setOnClickListener {
            thirdShapeColor = R.color.green
            fourthShapeColor = R.color.green
            fifthShapeColor = R.color.green
        }
        secondButton.setOnClickListener {
            thirdShapeColor = R.color.orange
            fourthShapeColor = R.color.orange
            fifthShapeColor = R.color.orange
        }
        thirdButton.setOnClickListener {
            thirdShapeColor = R.color.purple
            fourthShapeColor = R.color.purple
            fifthShapeColor = R.color.purple
        }
    }
}