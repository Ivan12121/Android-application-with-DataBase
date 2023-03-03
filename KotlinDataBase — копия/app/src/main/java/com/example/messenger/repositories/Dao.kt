package com.example.messenger.repositories

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.messenger.models.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insert(user: Users)
    @Query("SELECT * FROM users")
    fun select() : Flow<List<Users>>

}