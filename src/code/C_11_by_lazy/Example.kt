package code.C_11_by_lazy

class Example {
    val greeting: String by lazy { // 변수
        println("greeting이 초기화 됐음") // greeting 변수에 처음 접근할 때만 실행된다.
        "Hello Kotlin" // 메모리에 저장함으로써 실제 값이 할당됨
    }
}

fun main() {
    val example = Example()
    println("main 함수 실행, Example의 객체가 생성됐음.")

    println(example.greeting)
    println(example.greeting) // lazy 때문에 재접근 할 때 초기화 과정(변수를 사용하여 메모리에 값을 할당함)을 생략한다.
    /*
    main 함수 실행, Example의 객체가 생성됐음.
    greeting이 초기화 됐음
    Hello Kotlin
    Hello Kotlin
     */
}