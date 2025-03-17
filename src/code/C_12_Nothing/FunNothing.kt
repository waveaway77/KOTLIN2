package code.C_12_Nothing

class Example {
}

fun fail(message: String): Nothing { // 반환 타입이 Nothing이므로 강제로 종료된다. 절대 정상종료 되지 않는다. 값을 반환하지 않고, 예외를 던지고 종료된다.
    throw IllegalArgumentException(message)
}

fun main() {
    val result: String = fail("에러 발생") // 여기서 프로그램이 종료됨
    println(result) // 실행되지 않음
}