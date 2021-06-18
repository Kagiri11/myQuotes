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
    fun addQuote(quote:Quote)

    @Query("SELECT * FROM quote ORDER BY id DESC")
    fun getQuotes():LiveData<List<Quote>>?

    @Delete
    fun deleteQuote(quote: Quote)
}