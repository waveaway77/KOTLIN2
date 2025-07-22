package org.example.org.example.utils.mapper


// 자바나 코틀린은 컴파일할 때 제네릭 타입 정보를 지운다. 이걸 타입 소거(Type Erasure)라고 한다.

// 이 함수는 printType<String>("hello")처럼 호출해도, 런타임에는 T가 지워져서 정확한 타입을 모른다.
fun <T> printType1(value: T) {
//    println(value::class) // compile error
}

inline fun <reified T> printType2(value: T) { // value: T에서 T가 무슨 값인지를 <reified T> 덕분에 알게 된다
    println(T::class)  // T의 타입 정보를 쓸 수 있음
}

/*
inline	함수를 호출한 자리에 코드가 복사되게 해서 reified를 가능하게 함
reified	제네릭 타입 정보를 런타임까지 유지하게 함
 */


fun main() {
    printType1("hello") // class kotlin.String
    printType2("hello") // class kotlin.String
}