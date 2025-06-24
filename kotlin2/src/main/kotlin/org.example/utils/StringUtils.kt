package org.example.org.example.utils

fun extractPartnerIdFromPath(path: String?): String? {
    val parts = path?.trim('/')?.split("/") ?:return null // split 함수는 인자를 기준으로 문자열을 나누어 줍니다
    println(parts[0]) // 123
    println(parts[1]) // hana
    return parts[0]
}

fun main() {
    extractPartnerIdFromPath("/123/hana/")
}

fun trimFun() {

    // trim('/')를 하면 string의 앞뒤로 있는 / 를 모두 삭제해준다.

    val str1 = "//hello//world//"
    val trimmedStr1 = str1.trim('/')
    println(trimmedStr1) // hello//world

    val str2 = "///hello///"
    val trimmedStr2 = str2.trim { it == '/' }
    println(trimmedStr2) // hello

    val str3 = "  //hello//world//  "
    val trimmedStr3 = str3.trim().trim('/') // 앞뒤 공백도 제거하고 / 도 제거함
    println(trimmedStr3) // hello//world

    val str4 = " \t //hello//world// \t "
    val trimmedStr4 = str4.trim().trim('/')
    println(trimmedStr4) // hello//world

}