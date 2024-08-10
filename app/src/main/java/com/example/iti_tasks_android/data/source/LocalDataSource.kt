package com.example.iti_tasks_android.data.source

import com.example.iti_tasks_android.data.local.entity.InfoEntity

interface LocalDataSource {

    suspend fun addInfo(info: InfoEntity)
    suspend fun getInfo(): List<InfoEntity>
    suspend fun deleteInfo()
}