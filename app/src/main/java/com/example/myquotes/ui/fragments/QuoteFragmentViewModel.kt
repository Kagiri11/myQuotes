package com.example.myquotes.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.myquotes.data.QuoteDatabaseDao
import com.example.myquotes.models.Quote
import kotlinx.coroutines.launch

class QuoteFragmentViewModel : ViewModel() {
    lateinit var dao : QuoteDatabaseDao

    val quotes = liveData{
        emit(dao.getQuotes())
    }



}