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
import com.example.myquotes.databinding.FragmentMyQuotesBinding
import com.example.myquotes.ui.adapters.QuotesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyQuotesFragment : Fragment() {

    private val viewModel: QuoteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment

        val binding : FragmentMyQuotesBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_quotes,container,false)
        binding.fbAddQuote.setOnClickListener {
            findNavController().navigate(R.id.action_myQuotesFragment_to_addQuoteFragment)
        }

        viewModel.quotes.observe(viewLifecycleOwner, { quotes->
            binding.rvQuotes.adapter= QuotesAdapter(quotes,viewModel)
        })

        return binding.root

    }



}