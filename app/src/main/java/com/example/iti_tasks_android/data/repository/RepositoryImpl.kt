package com.example.iti_tasks_android.data.repository

import com.example.iti_tasks_android.data.local.entity.InfoEntity
import com.example.iti_tasks_android.data.source.LocalDataSource
import com.example.iti_tasks_android.data.source.RemoteDataSource

class RepositoryImpl(
    private val remoteDateSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : Repository {

    override suspend fun getAllProducts() = remoteDateSource.getAllProducts().body() ?: listOf()

    override suspend fun addInfo(info: InfoEntity) {
        localDataSource.addInfo(info)
    }

    override suspend fun getInfo(): List<InfoEntity>{
        return localDataSource.getInfo()
    }

    override suspend fun deleteInfo() {
        localDataSource.deleteInfo()
    }


}
