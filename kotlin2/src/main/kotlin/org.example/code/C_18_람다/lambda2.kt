package org.example.org.example.code.C_18_람다

// 코틀린 아카데미:함수형 프로그래밍 27p

// 익명함수
var cheer: () -> Unit = {
    println("Hi")
}
val printNumber: (Int) -> Unit = { i: Int ->
    println(i)
}
val log: (String, String) -> Unit = { s1: String, s2: String ->
    println(s1 + s2)
}

// 람다 표현식
val cheer2 = {
    println("Hi")
}
val printNumber2 = { i: Int ->
    println(i)
}
val log2 = { s1: String, s2: String ->
    println("[$s1] $s2")
}

// 매개변수 타입을 추론할 수 있을 경우
// (매개변수와 리턴값의 타입이 같을 경우)
// 람다 표현식에서 정의할 필요가 없다

val printNumber3: (Int) -> Unit = { i ->
    println(i)
}
val log3: (String, String) -> Unit = { s1, s2 ->
    println(s1 + s2)
}