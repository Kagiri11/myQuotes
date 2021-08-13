package com.example.myquotes.utils

object QuoteAdditionUtil {
    /**
     * The quote wont be valid if..
     * the message is empty or null,
     * the author name is empty or contains numbers or special characters
     */
    fun validateQuoteInput(message:String, author: String): Boolean{
        if(message.isEmpty() || author.isEmpty()){
            return false
        }
        if (author.contains("1234567890")){
            return false
        }
        return true
    }
}