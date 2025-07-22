package org.example.org.example.utils.StringUtils

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6) // 배열을 String으로 만들어준다. element 간의 구분자를 지정할 수 있다(seperator)
    println(numbers.joinToString()) // 1, 2, 3, 4, 5, 6
    println(numbers.joinToString(prefix = "[", postfix = "]")) // [1, 2, 3, 4, 5, 6]
    println(numbers.joinToString("•","<", ">")) // <1•2•3•4•5•6>

    val chars = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q')
    println(chars.joinToString(limit = 5, truncated = "...!") { it.uppercaseChar().toString() }) // A, B, C, D, E, ...!

}