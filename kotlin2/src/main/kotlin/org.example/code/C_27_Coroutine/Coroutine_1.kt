package org.example.org.example.code.C_27_Coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// https://kotlinlang.org/docs/coroutines-basics.html#your-first-coroutine

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking(비동기) delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello") // main coroutine continues while a previous one is delayed
    // 11라인이 기다리게 하든말든 14라인, main coroutine은 할 일을 한다
}
// Hello
// World!