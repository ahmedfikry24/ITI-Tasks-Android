package com.example.iti_tasks_android.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("infoEntity")
data class InfoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    @ColumnInfo
    val phone: Int,
    @ColumnInfo
    val message: String,
)
