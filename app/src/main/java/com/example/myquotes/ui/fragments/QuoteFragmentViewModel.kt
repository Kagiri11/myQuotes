package com.example.myquotes.ui.fragments

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.myquotes.data.QuoteDataBase
import com.example.myquotes.data.QuoteDatabaseDao
import com.example.myquotes.models.Quote
import kotlinx.coroutines.launch

class QuoteFragmentViewModel(private val dao : QuoteDatabaseDao, application: Application) : AndroidViewModel(application) {

    private val quoteOne = Quote(message = "Whether you think you can or cant, you are right", author = "Henry Ford")
    private val quoteTwo = Quote(
        message = "Man never made any material as resilient as the human spirit",
        author = "Bernard Williams"
    )

    init {
        addQuote(quoteOne)
    }

    val quotes = liveData{
        emit(dao.getQuotes())
    }

     fun addQuote(quote: Quote)=viewModelScope.launch {
        dao.addQuote(quote)
    }

    fun deleteQuote(quote:Quote)= viewModelScope.launch {
        dao.deleteQuote(quote)
        println("${quote.id} has been deleted")
    }
}