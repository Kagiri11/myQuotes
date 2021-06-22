package com.example.myquotes.ui.fragments

import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myquotes.R
import com.example.myquotes.data.QuoteDataBase
import com.example.myquotes.data.QuoteDatabaseDao
import com.example.myquotes.databinding.FragmentQuoteBinding
import com.example.myquotes.models.Quote
import com.example.myquotes.ui.adapters.QuotesAdapter


class QuoteFragment : Fragment() {

    lateinit var viewModelFactory: QuoteViewModelFactory
    lateinit var viewModel: QuoteFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding : FragmentQuoteBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_quote, container, false)

        val application = requireNotNull(this.activity).application
        val data = QuoteDataBase.getInstance(application).quoteDatabaseDao
        viewModelFactory = QuoteViewModelFactory(data,application)
        viewModel= ViewModelProvider(this,viewModelFactory).get(QuoteFragmentViewModel::class.java)
        binding.btnMyQuotes.setOnClickListener {
            findNavController().navigate(R.id.action_quote_to_quotes)
        }


        viewModel.quotes.observe(viewLifecycleOwner, Observer { quotes->
            val quote = quotes.random()
            binding.tvAuthor.text= quote.author
            binding.tvQuote.text= quote.message


        })

        return binding.root
    }


}