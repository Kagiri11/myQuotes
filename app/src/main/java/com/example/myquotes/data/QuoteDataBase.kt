package com.example.myquotes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myquotes.models.Quote

@Database(
    entities = [Quote::class],
    version = 1
)
abstract class QuoteDataBase : RoomDatabase(){
//    abstract fun getQuoteDatabaseDao(): QuoteDatabaseDao
    abstract val quoteDatabaseDao: QuoteDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE : QuoteDataBase?=null

        fun getInstance(context: Context) : QuoteDataBase{
            synchronized(this){
                var instance= INSTANCE

                if(instance==null){
                    instance =Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDataBase::class.java,
                        "quotes"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return  instance
            }
        }
    }

}