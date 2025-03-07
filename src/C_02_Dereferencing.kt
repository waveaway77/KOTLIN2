class Dereferencing {
}

// 함수 참조
fun greet(name: String) { println("Hello, $name!") }

// 변수 참조
var message = "oldMessage"

// 클래스 참조
class Person(val name: String) {
    // 여기서 Person::sayHello는 객체 없이 단독으로 실행되는 함수가 아니라, Person 객체가 있어야 실행할 수 있는 인스턴스 함수이다.
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

    /*
    Person::sayHello를 호출할 때 Person.sayHello 같은 모양이 아니라
    인자를 넘겨주는 형태(methodRef(person))가 되는 이유는,
    멤버 함수 참조(Member Function Reference)가 일반 함수 타입으로 변환될 때
    첫 번째 인자로 수신 객체(Receiver)를 받는 함수로 변환되기 때문이다.

    위 메서드를 코틀린의 컴파일러가 내부적으로 변환하는데...
    val methodRef: (Person) -> String = { person -> person.sayHello() } // Person을 받아서 Stringㅇ로 반환한다.
    즉, Person::sayHello는 사실상 아래와 같은 람다로 변환된다고 생각하면 된다.
    val methodRef = { person: Person -> person.sayHello() }
    그래서 methodRef(person)처럼 person 객체를 첫 번째 인자로 넘겨주는 형태가 된다.


    객체를 참조하는 함수는 일반 함수 타입으로 변환될 때 Person객체를 받아서 String을 반환하는 형태가 된다.
    methodRef는 (Person) -> String 타입의 함수가 된다. 즉, Person 객체를 받아야 실행할 수 있는 함수로 변환된다.
    Person::sayHello를 함수 참조로 사용할 때 객체가 필요하다는 정보가 사라지지 않는다.
    단지, 객체를 직접 전달해야 하는 형태로 변환될 뿐이다.
     */

    // 생성자 참조
    val constructorRef = ::User
    val user = constructorRef("Alice")
    println(user.name) // Bob
}