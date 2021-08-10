package com.example.myquotes.ui.fragments

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myquotes.R
import com.example.myquotes.databinding.FragmentQuoteBinding
import com.example.myquotes.models.CachedQuoteEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteFragment : Fragment() {

    private val viewModel: QuoteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding : FragmentQuoteBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_quote, container, false)

        binding.btnMyQuotes.setOnClickListener {
            findNavController().navigate(R.id.action_quote_to_quotes)
        }

        viewModel.quotes.observe(viewLifecycleOwner, { quotes->
            val quote = quotes.random()
            binding.apply {
                tvQuote.text= quote.message
                tvAuthor.text= quote.author
            }

        })

        return binding.root
    }
}