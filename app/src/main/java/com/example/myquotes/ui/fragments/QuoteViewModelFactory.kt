package com.example.myquotes.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class QuoteViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuoteFragmentViewModel::class.java)){
            return QuoteFragmentViewModel() as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }
}