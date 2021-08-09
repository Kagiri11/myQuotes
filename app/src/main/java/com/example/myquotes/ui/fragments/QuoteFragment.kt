package com.example.myquotes.ui.fragments

import android.content.Context
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
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


    private val viewModel: QuoteFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding : FragmentQuoteBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_quote, container, false)

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