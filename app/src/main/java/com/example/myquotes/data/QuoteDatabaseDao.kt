package com.example.myquotes.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myquotes.models.CachedQuoteEntity
import com.example.myquotes.models.Quote

@Dao
interface QuoteDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuote(quote:CachedQuoteEntity)

    @Query("SELECT * FROM quote ORDER BY id DESC")
    suspend fun getQuotes():List<CachedQuoteEntity>

    @Delete
    suspend fun deleteQuote(quote:CachedQuoteEntity)
}