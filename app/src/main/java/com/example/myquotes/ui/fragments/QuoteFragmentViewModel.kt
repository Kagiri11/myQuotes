package com.example.myquotes.ui.fragments

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.myquotes.data.QuoteDataBase
import com.example.myquotes.data.QuoteDatabaseDao
import com.example.myquotes.models.Quote
import kotlinx.coroutines.launch

class QuoteFragmentViewModel(private val dao : QuoteDatabaseDao) : ViewModel() {

    val quotes = liveData{
        emit(dao.getQuotes())
    }

     fun addQuote(quote: Quote)=viewModelScope.launch {
        dao.addQuote(quote)
    }

    fun deleteQuote(quote:Quote)= viewModelScope.launch {
        dao.deleteQuote(quote)
    }
}