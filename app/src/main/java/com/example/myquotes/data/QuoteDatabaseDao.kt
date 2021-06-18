package com.example.myquotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.myquotes.models.Quote

@Dao
interface QuoteDatabaseDao {

    @Insert
    fun addQuote(quote:Quote)

    @Delete
    fun deleteQuote(quote: Quote)
}