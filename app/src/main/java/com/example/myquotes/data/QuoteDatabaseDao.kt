package com.example.myquotes.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myquotes.models.Quote

@Dao
interface QuoteDatabaseDao {

    @Insert
    suspend fun addQuote(quote:Quote)

    @Query("SELECT * FROM quote ORDER BY id DESC")
    suspend fun getQuotes():List<Quote>

    @Delete
    suspend fun deleteQuote(quote:Quote)
}