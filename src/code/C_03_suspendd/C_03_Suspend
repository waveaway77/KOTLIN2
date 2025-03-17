package code

import kotlinx.coroutines.*

class C_03_Suspend {
}

// suspend 키워드는 코틀린에서 코루틴을 지원하는 함수임을 나타내는 역할을 한다.
// 1. 네트워크 요청, 파일 I/O, 데이터베이스 쿼리 같은 작업을 코루틴으로 비동기 실행할 수 있다.
// 2. 기존의 콜백 기반 비동기 코드를 간단하게 만들 수 있다. (uspend 함수는 콜백 없이도 비동기 작업을 처리할 수 있다.)
// 3. suspend 함수는 실행을 멈추고 다른 작업을 수행한 뒤, 나중에 다시 이어서 실행될 수 있다.

// suspend가 없으면 일시 중단 함수(예: delay())를 호출할 수 없으며, 코루틴 안에서 실행할 수 없다.
// 만약 suspend 없이 비동기 처리를 하고 싶다면,
// 콜백(callback)이나
// Thread.sleep() 같은 블로킹 방식을 사용해야 한다.

// suspend가 있는 경우
suspend fun fetchData(): String {
    delay(1000)
    return "데이터 가져오기 완료"
}

fun main() = runBlocking {
    println("데이터 가져오는 중")
    val data = fetchData()
    println(data)
}