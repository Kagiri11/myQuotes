package com.example.myquotes.ui.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.R
import com.example.myquotes.models.CachedQuoteEntity
import com.example.myquotes.ui.fragments.QuoteViewModel

class QuotesAdapter(private val quotes: List<CachedQuoteEntity>, private val viewModel: QuoteViewModel) :
    RecyclerView.Adapter<QuotesAdapter.QuotesAdapterViewHolder>(){

    private var quotelist = quotes as MutableList<CachedQuoteEntity>

    inner class QuotesAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val author : TextView = view.findViewById(R.id.tv_Author_Item)
        val message : TextView = view.findViewById(R.id.tv_Quote_Item)
        val delBtn : ImageButton= view.findViewById(R.id.iv_Delete_Article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesAdapterViewHolder {
        return QuotesAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_quote,parent,false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: QuotesAdapterViewHolder, position: Int) {
        val quoteItem = quotes[position]
        holder.apply {
            message.text = "~ ${quoteItem.message}"
            author.text= quoteItem.author
            delBtn.setOnClickListener {
                viewModel.deleteQuote(quoteItem)
                deleteItem(position)
                notifyDataSetChanged()
            }
        }
    }

    private fun deleteItem(index: Int){
        quotelist.removeAt(index)
    }

    override fun getItemCount(): Int =quotes.size
}