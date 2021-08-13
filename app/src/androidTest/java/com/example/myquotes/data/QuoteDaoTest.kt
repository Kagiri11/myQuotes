package com.example.myquotes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.myquotes.models.CachedQuoteEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class QuoteDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dataBase: QuoteDataBase
    private lateinit var quoteDao : QuoteDatabaseDao

    @Before
    fun setup(){
        dataBase= Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDataBase::class.java
        ).allowMainThreadQueries().build()
        quoteDao = dataBase.quoteDatabaseDao
    }

    @After
    fun tearDown(){
        dataBase.close()
    }

    @Test
    fun insertQuote()=runBlockingTest{
        val quoteEntity = CachedQuoteEntity(2,message = "Go build yourself",author = "Vick BBIT")
        quoteDao.addQuote(quoteEntity)
        val allQuotes = quoteDao.getQuotes()
        assertThat(allQuotes).contains(quoteEntity)
    }


}