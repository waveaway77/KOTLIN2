package org.example.org.example.utils.time

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// LocalDateTime
val current = LocalDateTime.now()

// Formatter
val formatter1 = DateTimeFormatter.ISO_LOCAL_DATE // 2025-04-27
val formatter2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME // 2025-04-17T17:49:35.3189044

// 양식만들기
val formatter3 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss") // 20250417175021
val formatter4 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초") // 2025년 04월 17일 17시 50분 48초
val formatted = current.format(formatter4)

fun main() {
    println(formatted)

    println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
}


fun returnStr(): String {
    val randomDate = "19960427093045"
    val year = randomDate.substring(0, 4)
    val month = randomDate.substring(4, 6)
    return "$year$month"
}