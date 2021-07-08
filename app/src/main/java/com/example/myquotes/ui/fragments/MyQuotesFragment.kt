    package com.example.myquotes.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.R
import com.example.myquotes.data.QuoteDataBase
import com.example.myquotes.databinding.FragmentMyQuotesBinding
import com.example.myquotes.ui.adapters.QuotesAdapter

class MyQuotesFragment : Fragment() {
    lateinit var viewModelFactory: QuoteViewModelFactory
    lateinit var viewModel: QuoteFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment

        val binding : FragmentMyQuotesBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_quotes,container,false)
        binding.fbAddQuote.setOnClickListener {
            findNavController().navigate(R.id.action_myQuotesFragment_to_addQuoteFragment)
        }
        val application = requireNotNull(this.activity).application
        val data = QuoteDataBase.getInstance(application).quoteDatabaseDao
        viewModelFactory = QuoteViewModelFactory(data,application)
        viewModel= ViewModelProvider(this,viewModelFactory).get(QuoteFragmentViewModel::class.java)

        viewModel.quotes.observe(viewLifecycleOwner, Observer { quotes->
            binding.rvQuotes.adapter=QuotesAdapter(quotes,viewModel)

        })

        return binding.root

    }



}