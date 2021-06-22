package com.example.myquotes.ui.fragments

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.myquotes.data.QuoteDataBase
import com.example.myquotes.data.QuoteDatabaseDao
import com.example.myquotes.models.Quote
import kotlinx.coroutines.launch

class QuoteFragmentViewModel(private val dao : QuoteDatabaseDao, application: Application) : AndroidViewModel(application) {

    private val quoteOne = Quote(message = "Give me the loving", author = "Sean Paul")
    init {
        addQuote(quoteOne)
    }

    val quotes = liveData{
        emit(dao.getQuotes())
    }

    private fun addQuote(quote: Quote)=viewModelScope.launch {
        dao.addQuote(quote)
    }



}