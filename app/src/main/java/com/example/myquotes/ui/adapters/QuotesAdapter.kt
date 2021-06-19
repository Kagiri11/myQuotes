package com.example.myquotes.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.R
import com.example.myquotes.databinding.FragmentMyQuotesBinding
import com.example.myquotes.models.Quote

class QuotesAdapter(private val quotes : List<Quote>) : RecyclerView.Adapter<QuotesAdapter.QuotesAdapterViewHolder>() {

    inner class QuotesAdapterViewHolder(private val binding: FragmentMyQuotesBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(context: Context,quote: Quote){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : FragmentMyQuotesBinding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_my_quotes,parent,false)

        return QuotesAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuotesAdapterViewHolder, position: Int) {
        val quoteItem = quotes[position]
        holder.itemView
    }

    override fun getItemCount(): Int = quotes.size
}