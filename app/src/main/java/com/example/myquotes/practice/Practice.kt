package com.example.myquotes.practice

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.*

fun simple(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}

fun main()= runBlocking {
    doThis()
}

suspend fun doThis()= coroutineScope {
    val job1=launch {
        delay(5000L)
        println("World One")
    }
    println("Hello")
    job1.join()
    println("Done")
}

fun showNames(): Flow<String> = flow{
    val names = mutableListOf("Joan", "Mary", "Magdalene", "Hailey", "Kygo", "Rita")
    for (item in names){
        delay(100)
        emit(item)
    }
}