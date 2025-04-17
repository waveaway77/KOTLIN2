package code.C_12_Nothing

class GenericNothing {
}

/*
제네릭에서 Nothing을 사용하는 이유
이 함수는 어떠한 타입도 반환하지 않는다는 의미를 가진다.

Nothing은 절대 정상적인 값을 반환하지 않는 타입이므로, 어떤 타입으로도 대체 가능하다.
즉, 모든 타입의 하위 타입이므로, 제네릭에서 "어떤 타입이 와도 컴파일 오류 없이 처리 가능하게" 하기 위해 사용된다.
 */

fun <T> fail(message: String): T = throw IllegalArgumentException(message)
fun failWithNothing(message: String): Nothing = throw IllegalArgumentException(message)

fun main() {
    val result: String = fail("에러 발생") // String 타입으로도 가능하고
    val number: Int = fail("또 다른 에러 발생") // Int 타입으로도 가능하다

    val error: Nothing = failWithNothing("정확한 의미 전달") // 정상적으로 값을 반환하지 않는 함수임을 직관적으로 표시
}