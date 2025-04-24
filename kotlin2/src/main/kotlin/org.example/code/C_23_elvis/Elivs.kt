package org.example.org.example.code.C_23_elvis

val name: String? = ""
val safeName = name ?: "" // null이라면 ""을 쓰세요

fun main() {
    println("safeName is [$safeName]") // safeName is []
}

//val safeName2?: "" // error