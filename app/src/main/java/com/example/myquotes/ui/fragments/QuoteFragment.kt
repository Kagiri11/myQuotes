package com.example.myquotes.ui.fragments

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myquotes.R
import com.example.myquotes.databinding.FragmentQuoteBinding


class QuoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentQuoteBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_quote, container, false)

        binding.btnMyQuotes.setOnClickListener {
            findNavController().navigate(R.id.action_quote_to_quotes)
        }

        return binding.root
    }
}