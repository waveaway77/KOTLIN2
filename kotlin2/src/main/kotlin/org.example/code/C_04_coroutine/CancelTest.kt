package org.example.org.example.code.C_04_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// https://rkdxowhd98.tistory.com/59
fun main() = runBlocking { // runBlocking은 suspend 상태임을 의미한다
    val job = launch { // launch는 job을 반환한다
        repeat(5) { // 5개의 job이 생성될 것이다
            try {
                println("job start index($it)")
                delay(1000L)
            } catch (e: Exception) {
                println("exception occurred. stacktrace is ... $e.printStackTrace()")
            }
        }
    }

    delay(3000L) // 3초 후에
    job.cancel() // 캔슬한다
    job.join() // 캔슬된 잡한테 대기하라고 명령한다 >> exception 발생
}
/*

job start index(0)
job start index(1)
job start index(2)
exception occurred. stacktrace is ... kotlinx.coroutines.JobCancellationException: StandaloneCoroutine was cancelled; job=StandaloneCoroutine{Cancelling}@60f82f98.printStackTrace()
job start index(3)
exception occurred. stacktrace is ... kotlinx.coroutines.JobCancellationException: StandaloneCoroutine was cancelled; job=StandaloneCoroutine{Cancelling}@60f82f98.printStackTrace()
job start index(4)
exception occurred. stacktrace is ... kotlinx.coroutines.JobCancellationException: StandaloneCoroutine was cancelled; job=StandaloneCoroutine{Cancelling}@60f82f98.printStackTrace()

종료 코드 0(으)로 완료된 프로세스


 */