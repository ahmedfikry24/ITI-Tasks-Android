package com.example.iti_tasks_android

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listView = findViewById(R.id.list_view)
        val daysOfWeek = listOf(
            ItemInfo("Sunday"),
            ItemInfo("Monday"),
            ItemInfo("Tuesday"),
            ItemInfo("Wednesday"),
            ItemInfo("Thursday"),
            ItemInfo("Friday"),
            ItemInfo("Saturday"),
        )

        val adapter = ListViewAdapter(this, daysOfWeek)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, _, position, _ ->
            val selectedDay = parent.getItemAtPosition(position) as ItemInfo
            Toast.makeText(this, selectedDay.day, Toast.LENGTH_SHORT).show()
        }
    }
}