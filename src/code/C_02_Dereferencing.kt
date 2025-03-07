package code

class Dereferencing {
}

// 함수 참조
fun greet(name: String) { println("Hello, $name!") }

// 변수 참조
var message = "oldMessage"

// 클래스 참조
class Person(val name: String) {
    fun sayHello() { println("Hello, $name!") }
}

// 생성자 참조
class User(val name: String) {}

fun main() {
    // 함수 참조
    val reference = ::greet
    reference("Kotlin") // Hello, Kotlin!

    // 변수 참조
    val propRef = ::message
    println(propRef.get()) // oldMessage
    propRef.set("newMassage")
    println(message) // newMessage

    // 클래스의 멤버 참조
    val methodRef = Person::sayHello
    val person = Person("Alice")
//    val person = "alice" // 불가능하다.
    println(methodRef(person)) // Hello, my name is Alice

    // 생성자 참조
    val constructorRef = ::User
    val user = constructorRef("Alice")
    println(user.name) // Bob
}