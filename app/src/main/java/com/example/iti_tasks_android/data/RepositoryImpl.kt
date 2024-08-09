package com.example.iti_tasks_android.data

import com.example.iti_tasks_android.data.source.RemoteDateSourceImpl

class RepositoryImpl(
    private val remoteDateSource: RemoteDateSourceImpl
) : Repository {

    override suspend fun getAllProducts() = remoteDateSource.getAllProducts().body() ?: listOf()
}
