package com.example.iti_tasks_android.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.iti_tasks_android.data.local.entity.InfoEntity

@Dao
interface InfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addInfo(infoEntity: InfoEntity)

    @Query("SELECT * FROM INFOENTITY")
    suspend fun getInfo(): List<InfoEntity>

    @Query("DELETE FROM INFOENTITY")
    suspend fun deleteInfo()
}