package org.example.org.example.code.C_31_forEach

import code.interfaces.kotlincode.Animal
import code.interfaces.kotlincode.Cat
import code.interfaces.kotlincode.Dog

class ForEach {
}

fun main() {
/*

error

    val animals: List<Any> = listOf("a", "b", "c")
    animals.forEach {
        (element) -> println(element)
    }
    */

    // forEach 안에서 (element, item) -> ...처럼 괄호로 감싼 매개변수
    // 해당 람다의 매개변수가 튜플(예: Map.Entry, Pair, 구조 분해 가능 객체)일 때만 가능
    val map = mapOf("a" to 1, "b" to 2)
    map.forEach { (key, value) ->
        println("$key -> $value")
        // a -> 1
        // b -> 2
    }

}