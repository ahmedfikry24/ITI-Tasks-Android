package com.example.iti_tasks_android.data.source

import androidx.lifecycle.LiveData
import com.example.iti_tasks_android.data.local.InfoDao
import com.example.iti_tasks_android.data.local.RoomManager
import com.example.iti_tasks_android.data.local.entity.InfoEntity

class LocalDataSourceImpl(
    private val roomManager: RoomManager
) : LocalDataSource {
    override suspend fun addInfo(info: InfoEntity) {
        roomManager.infoDao.addInfo(info)
    }

    override suspend fun getInfo(): List<InfoEntity> {
        return roomManager.infoDao.getInfo()
    }

    override suspend fun deleteInfo() {
        roomManager.infoDao.deleteInfo()
    }
}
