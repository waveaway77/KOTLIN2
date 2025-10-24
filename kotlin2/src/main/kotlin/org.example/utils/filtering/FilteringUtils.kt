package org.example.org.example.utils.filtering

class FilteringUtils {
}

fun main() {
    val inputList = listOf("A", "B", "C")
    val targetList = listOf("AA", "BB", "CC")

    if (!targetList.all { it in inputList }) { // true 일 때 실행됨
        println("true")
    }
}