package com.example.myquotes.di

import android.content.Context
import androidx.room.Room
import com.example.myquotes.data.QuoteDataBase
import com.example.myquotes.data.QuoteDatabaseDao
import com.example.myquotes.models.mappers.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideQuoteDB(@ApplicationContext context : Context) : QuoteDataBase{
        return Room.databaseBuilder(context,QuoteDataBase::class.java,QuoteDataBase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteDataBaseDao(quoteDataBase: QuoteDataBase): QuoteDatabaseDao{
        return quoteDataBase.quoteDatabaseDao
    }
}