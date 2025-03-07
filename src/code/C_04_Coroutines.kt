package code

import kotlinx.coroutines.*

class C_04_Coroutines {

}
fun main() = runBlocking {
    launch {
        println("코루틴 1 시작")
        delay(1000)  // 1초 동안 일시 중단 (하지만 스레드는 차단되지 않음)
        println("코루틴 1 종료")
    }

    launch {
        println("코루틴 2 시작")
        repeat(5) { i ->
            println("코루틴 2 작업 중... $i")
            delay(300)  // 0.3초마다 반복 작업 수행
        }
        println("코루틴 2 종료")
    }

    println("메인 스레드 실행 중...")
}
