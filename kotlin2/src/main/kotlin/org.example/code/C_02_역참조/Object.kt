package org.example.org.example.code.C_02_역참조

// 함수 참조

fun sum(a: Int, b: Int): Int {
    var sum = 0
    for (i in a..b) {
        sum += i
    }
    return sum
}

fun product(a: Int, b: Int): Int {
    var product = 1
    for (i in a..b) {
        product *= i
    }
    return product
}

fun main() {
    sum(5, 10) // 45
    product(5, 10) // 151200
}

// 람다 표현식
//fun sum3(a: Int, b: Int) = fold(a,b,0, { x, y -> x + y })

// 메서드 참조로 표현한 sum과 proudct 함수
fun sum2(a: Int, b: Int) =
    (a..b).fold(0, Int::plus)
fun product2(a: Int, b: Int) =
    (a..b).fold(1, Int::times)
