package org.example.org.example.code.C_04_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello")
    job.join() // wait until child coroutine completes
    println("Done")
}
/*
Hello
World!
Done

join은 코루틴에게 자식 코루틴이 종료될때까지 기다리라고 명령하는 함수입니다.
job.join()이 있기 때문에, Hello 이후 (World!를 출력하는) job이 종료될 때까지 기다렸다가 종료되고 Done이 나온다.


 */