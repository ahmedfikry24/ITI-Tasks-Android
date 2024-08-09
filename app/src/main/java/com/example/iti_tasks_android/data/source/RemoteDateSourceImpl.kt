package com.example.iti_tasks_android.data.source

import com.example.iti_tasks_android.data.remote.RetrofitServices

class RemoteDateSourceImpl(
    private val retrofitServices: RetrofitServices
) : RemoteDataSource {

    override suspend fun getAllProducts() = retrofitServices.getProducts()

}