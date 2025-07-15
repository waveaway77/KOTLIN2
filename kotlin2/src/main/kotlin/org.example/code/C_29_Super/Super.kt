package org.example.org.example.code.C_29_Super

open class Father {
    open fun hello() {
        println("hello, i'm father")
    }
}

class Daughter(): Father() {
//    val daughter : Father = super.hello() // super.hello()의 리턴 타입이 Unit이라서 컴파일러 에러 발생
    val daughter: Unit = super.hello() // super는 Father이다
}

class SuperTestClass3() {
}