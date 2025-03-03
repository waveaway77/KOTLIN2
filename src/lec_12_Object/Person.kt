package lec_12_Object/*
1. static
2. singleton
3. 익명클래스
 */

fun main() {
    Singleton.a
}

class Person private constructor(
    var name: String,
    var age: Int,
) {

    companion object Factory : Log { // static, Factory라는 이름
        private const val MIN_AGE = 0 // const(상수) : 런타임이 아닌 컴파일 시에 변수가 할당된다. 상수한테 붙여준다.
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행객체입니다")
        }
    }

}

object Singleton { // 객체
    var a: Int = 0
}

/*

java의 익명클래스 new 타입이름()
Kotlin에서는 object : 타입이름

 */