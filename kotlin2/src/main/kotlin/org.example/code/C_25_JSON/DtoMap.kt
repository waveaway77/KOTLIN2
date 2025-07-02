package org.example.org.example.code.C_25_JSON

data class AnimalRequest(
    val cat : String = "",
    val dog : String = ""
)

fun main(args: Array<String>) {

    /* 가능 */
    greet("A")
    greet("A", "B")
    greet("A", "B", "C")

    bye("a", "b", "c")

    test()

    val animalRequest = AnimalRequest("meow", "woof")
}

fun greet(vararg names: String) {
    for (name in names) println("Hello, $name")
    /*
    Hello, A
    Hello, A
    Hello, B
    Hello, A
    Hello, B
    Hello, C
    */
}

fun bye(vararg names: String) {
    val upper = names.map { it.uppercase() } // 그 결과을 요소로 가지는 리스트를 만든다.
    /*
    [A, B, C]
    */
    println(upper)
}

fun test() {
    val a = "abcde".map { it.uppercase() }
    a.joinToString { " " }
    val b = "abcde".map { it.uppercase() }
    b.joinToString { "" }

    println(a) // [A, B, C, D, E]
    println(b) // [A, B, C, D, E]

    val names = listOf("A", "B", "C")
    val result = names.joinToString()
    println(result)  // 출력: A, B, C
    val result2 = names.joinToString("")
    println(result2)  // 출력: ABC
    /*
    파라미터	의미
separator	요소 사이의 구분자 (기본값: ", ")
prefix	결과 문자열 앞에 붙일 문자열
postfix	결과 문자열 뒤에 붙일 문자열
람다	각 요소를 문자열로 가공하는 방법 지정
     */
}