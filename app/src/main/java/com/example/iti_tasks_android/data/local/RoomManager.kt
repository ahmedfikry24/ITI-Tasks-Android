package com.example.iti_tasks_android.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.iti_tasks_android.data.local.entity.InfoEntity

@Database(entities = [InfoEntity::class], version = 1)
abstract class RoomManager : RoomDatabase() {

    abstract val infoDao: InfoDao

    companion object {
        @Volatile
        private var instance: RoomManager? = null

        fun getInit(context: Context): RoomManager {
            return instance ?: synchronized(context) {
                return instance ?: Room
                    .databaseBuilder(
                        context.applicationContext,
                        RoomManager::class.java,
                        "infoDataBase"
                    )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it }
            }
        }

    }
}
