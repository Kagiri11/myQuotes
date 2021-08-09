package com.example.myquotes.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class CachedQuoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int=0,

    val message : String,

    val author : String
)
