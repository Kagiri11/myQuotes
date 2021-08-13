package com.example.myquotes

import com.example.myquotes.utils.QuoteAdditionUtil
import com.google.common.truth.Truth.assertThat

import org.junit.Test

class QuoteAdditionUtilTest{
    @Test
    fun `empty or null message returns false`(){
        val resultCheck = QuoteAdditionUtil
            .validateQuoteInput(message = "",author = "Mehmed")
        assertThat(resultCheck).isFalse()
    }

    @Test
    fun `author name is empty returns false`(){
        val resultCheck = QuoteAdditionUtil
            .validateQuoteInput(message = "Be the best",author = "")
        assertThat(resultCheck).isFalse()
    }

    @Test
    fun `author name does not contain numbers and character and is not empty returns true `(){
        val author = "Frank"
        val resultCheck = QuoteAdditionUtil
            .validateQuoteInput(message = "Be the best",author = author)
        assertThat(author).doesNotContainMatch("1234567890")
        assertThat(resultCheck).isTrue()
        assertThat(author).isNotEmpty()
    }

}