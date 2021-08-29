package com.example.myquotes.ui.fragments

import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.myquotes.data.QuoteDatabaseDao
import com.example.myquotes.models.CachedQuoteEntity
import kotlinx.coroutines.launch


class QuoteViewModel @ViewModelInject
     constructor(private val dao : QuoteDatabaseDao) : ViewModel() {

    val quotes = liveData{
        emit(dao.getQuotes())
    }

     fun addQuote(quote: CachedQuoteEntity)=viewModelScope.launch {
        dao.addQuote(quote)
    }

    fun deleteQuote(quote:CachedQuoteEntity)= viewModelScope.launch {
        dao.deleteQuote(quote)
    }
}