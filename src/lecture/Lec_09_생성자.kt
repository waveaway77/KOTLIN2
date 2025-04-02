package lecture

import kotlin.reflect.KClass

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

/*
    클래스 선언	            Getter 생성	Setter 생성	유형
class Person(name: String)	    X	        X	    생성자 매개변수
class Person(var name: String)	O	        O	    속성
class Person(val name: String)	O	        X	    속성
 */

/*
get() = 을 통해 고정적인 값을 반환을 할 수 있지만,
get(){ 연산 로직 작성 } 중괄호 안에 연산이 필요한 코드를 적용할 수도 있습니다.
 */