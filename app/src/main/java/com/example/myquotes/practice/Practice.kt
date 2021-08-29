package com.example.myquotes.practice

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.*

fun simple(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}

fun main() {

    val  greats = flowOf("Charles","Kagiri","Maina")
    val booty= showNames()
    runBlocking {
        val names = mutableListOf("Joan", "Mary", "Magdalene", "Hailey", "Kygo", "Rita").asFlow().collect {
            println(it)
        }
    }
}

fun showNames(): Flow<String> = flow{
    val names = mutableListOf("Joan", "Mary", "Magdalene", "Hailey", "Kygo", "Rita")
    for (item in names){
        delay(100)
        emit(item)
    }
}