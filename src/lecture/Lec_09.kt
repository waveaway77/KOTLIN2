package lecture

class Lec_09 {
}

class Person0 // 파라미터가 하나도 없다면 생성자 부분이 제외 가능하다
class Person1 constructor(val name: String, var age: Int) // 바디 생략가능
class Person2(val name: String, var age: Int) // constructor 예약어 생략가능
class Person3(val name: String, var age: Int) {

    constructor(name: String): this(name, 1)
    // name만 인자로 받는다
    // this가 주생성자를 호출한다.

    constructor() : this("홍길동") // 부생성자는 무조건 주생성자에게 직간접적으로 생성을 위임해야 하

}


fun main() {
    // 생성자 없는 클래스의 호출도 가능하다.
    Person0()

    // getter, setter가 없는 모습
    val person = Person1("최태현", 23)
    person.name
    person.age = 10
}