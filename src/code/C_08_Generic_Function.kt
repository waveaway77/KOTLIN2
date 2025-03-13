package code

class C_08_Generic_Function {
}

// 특정 타입만 사용 가능한 일반 함수
fun printInt(value: Int) = println(value)
fun printString(value: String) = println(value)
// printInt("Hello") // 불가능

// 제너릭 함수는 다양한 타입을 처리 가능
fun <T> printAnything(value: T) = println(value)
fun main() {
    printAnything(10)
    printAnything("Hello")
    printAnything(10.0)
}
// 함수 하나로 어떤 타입이든 받을 수 있다.
// 코드의 중복없이 유연하게 쓸 수 있다.

/*
여기서 **첫 번째 <T>**는 이 함수가 제네릭을 사용할 거라는 선언이야.
즉, "어떤 타입이든 T라는 이름으로 받아서 쓸 거야!" 라는 의미다.
이 부분이 없으면, 코틀린은 swap()이 제네릭 함수인지 모른다.

코틀린은 클래스에 상속하거나 디자인 패턴을 사용하지 않고 새로운 기능으로 클래스를 확장 할 수 있는 기능을 제공하는데 이것이 확장(extension)이라는 선언을 통해 이루어진다.
이때 추가적인 메소드를 구현하면 이를 "확장 함수"라고 하고 추가적인 프로퍼티를 구현하면 "확장 프로퍼티"라고 한다.

외부 라이브러리(third-party library)를 사용할 때는 함수를 추가하기가 매우 어렵


 */