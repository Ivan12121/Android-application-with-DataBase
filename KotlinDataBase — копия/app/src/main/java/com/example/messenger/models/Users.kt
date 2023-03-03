package com.example.messenger.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users (
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "surname")
    var surname: String,
    @ColumnInfo(name = "password")
    var password: Int
        )