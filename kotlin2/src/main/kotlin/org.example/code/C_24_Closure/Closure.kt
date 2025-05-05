package org.example.org.example.code.C_24_Closure
fun count(): Int {
    var i = 0
    i++
    return i
}

fun makeCounter(): () -> Int {
    var i = 0
    return { i++ }
}

fun main() {
    val counter1 = makeCounter()
    val counter2 = makeCounter()

    println(counter1()) // 0
    println(counter1()) // 1
    println(counter2()) // 0
    println(counter1()) // 2
    println(counter1()) // 3
    println(counter2()) // 1

    println(count()) // 1
    println(count()) // 1
    println(count()) // 1
}
