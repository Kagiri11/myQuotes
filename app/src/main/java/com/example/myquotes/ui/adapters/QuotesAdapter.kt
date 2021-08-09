package com.example.myquotes.ui.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.R
import com.example.myquotes.models.Quote
import com.example.myquotes.ui.fragments.QuoteFragmentViewModel

class QuotesAdapter(private val quotes : List<Quote>,val viewModel: QuoteFragmentViewModel) :
    RecyclerView.Adapter<QuotesAdapter.QuotesAdapterViewHolder>(){

    private var quotelist = quotes as MutableList<Quote>

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

    override fun onBindViewHolder(holder: QuotesAdapterViewHolder, position: Int) {
        val quoteItem = quotes[position]
        holder.author.text=quoteItem.author
        holder.message.text = quoteItem.message
        holder.delBtn.setOnClickListener {
            viewModel.deleteQuote(quoteItem)
            deleteItem(position)
            notifyDataSetChanged()
        }


    }

    fun deleteItem(index: Int){
        quotelist.removeAt(index)
    }
    override fun getItemCount(): Int =quotes.size
}