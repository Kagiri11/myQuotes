package com.example.myquotes.ui.fragments

import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myquotes.R
import com.example.myquotes.data.QuoteDataBase
import com.example.myquotes.databinding.FragmentAddQuoteBinding
import com.example.myquotes.models.CachedQuoteEntity
import com.example.myquotes.models.Quote
import com.example.myquotes.utils.QuoteAdditionUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddQuoteFragment : Fragment() {

    private val viewModel: QuoteViewModel by viewModels()
    private lateinit var binding: FragmentAddQuoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_quote,container,false)

        val message = binding.etQuoteMessage.text.toString()
        val author = binding.etQuoteAuthor.text.toString()

        binding.btnAddQuote.setOnClickListener {

            findNavController().navigate(R.id.action_addQuoteFragment_to_quoteFragment)
        }

        return binding.root
    }

    fun addQuote(message: String, author: String){
        QuoteAdditionUtil.validateQuoteInput(message = message, author = author)

        val quote = CachedQuoteEntity(message=message,author = author)
        viewModel.addQuote(quote)
    }

}