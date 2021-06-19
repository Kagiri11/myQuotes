package com.example.myquotes.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myquotes.models.Quote

class QuoteViewModel  : ViewModel(){
    //the quote to be shown
    private var _quote = MutableLiveData<Quote>()
    val quote : LiveData<Quote> = _quote

}