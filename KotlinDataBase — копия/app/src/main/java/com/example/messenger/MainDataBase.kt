package com.example.messenger

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.messenger.models.Users
import com.example.messenger.repositories.Dao

@Database(entities = [Users::class], version = 1)
abstract class MainDataBase : RoomDatabase() {
    abstract fun getDao() : Dao
    companion object {
        fun getDataBase(contex: Context) : MainDataBase {
            return Room.databaseBuilder(contex.applicationContext, MainDataBase::class.java, "test.db").build()
        }
    }
}