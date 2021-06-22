package com.example.myquotes.ui.fragments

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myquotes.data.QuoteDatabaseDao
import java.lang.IllegalArgumentException

class QuoteViewModelFactory(private val dao : QuoteDatabaseDao, val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuoteFragmentViewModel::class.java)){
            return QuoteFragmentViewModel(dao,application) as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }
}