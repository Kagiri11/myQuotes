package com.example.myquotes.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.R
import com.example.myquotes.models.Quote

class QuotesAdapter(private val quotes : List<Quote>):  RecyclerView.Adapter<QuotesAdapter.QuotesAdapterViewHolder>(){

    class QuotesAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val author : TextView = view.findViewById(R.id.tv_Author_Item)
        val message : TextView = view.findViewById(R.id.tv_Quote_Item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesAdapterViewHolder {
        return QuotesAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_quote,parent,false)
        )
    }

    override fun onBindViewHolder(holder: QuotesAdapterViewHolder, position: Int) {
        val quoteItem = quotes[position]
        holder.author.text=quoteItem.author
        holder.message.text = quoteItem.message

    }

    override fun getItemCount(): Int =quotes.size
}