package org.example.org.example.utils

fun main() {
    println("result is "+fun_take("a"))
}

fun fun_take(value: String): String {
    try {
        val cleaned = value.replace(" ", "")
        return cleaned.take(3)
    } catch (e: Exception) {
        // 에러 발생하지 않음 >>> https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/take.html
        println("error occured. ${e.message}")
        return ""
    }
}