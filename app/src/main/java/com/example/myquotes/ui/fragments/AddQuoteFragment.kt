package com.example.myquotes.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myquotes.R
import com.example.myquotes.data.QuoteDataBase
import com.example.myquotes.databinding.FragmentAddQuoteBinding
import com.example.myquotes.models.Quote

class AddQuoteFragment : Fragment() {
    lateinit var viewModelFactory: QuoteViewModelFactory
    lateinit var viewModel: QuoteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentAddQuoteBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_quote,container,false)
        val application = requireNotNull(this.activity).application
        val data = QuoteDataBase.getInstance(application).quoteDatabaseDao
        viewModelFactory = QuoteViewModelFactory(data,application)
        viewModel= ViewModelProvider(this,viewModelFactory).get(QuoteFragmentViewModel::class.java)

        val message = binding.etQuoteMessage.text.toString()
        val author = binding.etQuoteAuthor.text.toString()
        val quote = Quote(message=message,author = author)
        binding.btnAddQuote.setOnClickListener {
            viewModel.addQuote(quote)
            
        }

        return binding.root
    }

}