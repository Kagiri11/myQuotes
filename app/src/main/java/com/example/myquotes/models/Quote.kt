package com.example.myquotes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0L,
    @ColumnInfo
    val message : String,
    @ColumnInfo
    val author : String
)
