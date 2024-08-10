package com.example.iti_tasks_android.data.repository

import com.example.iti_tasks_android.data.local.entity.InfoEntity
import com.example.iti_tasks_android.data.models.ProductDto

interface Repository {

    suspend fun getAllProducts(): List<ProductDto>
    suspend fun addInfo(info: InfoEntity)
    suspend fun getInfo(): List<InfoEntity>
    suspend fun deleteInfo()
}