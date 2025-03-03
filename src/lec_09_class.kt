코틀린 클래스
1. 클래스와 프로퍼티
2. 생성자와 init
3. 커스텀 getter, setter
4. backing field
---
1.
J
public class JavaPerson {
    private final String name; // final이므로 setter가 없다
    private int age;
    // 생성자, getter, setter
}

K
class Person constructor(name: String, age: Int) { // 생성자, 생략가능하다.
    class Person (name: String, age: Int) { // 생성자, 생략가능하다.
        val name: String = name // final
        var age: Int = age
// 필드만 만들면 getter setter가 자동으로 생성됨
    }

    class Person (val name: String, var age: Int) { 바디 생략가능 }

    fun main() {
        val person = Person("최태현", 23)
        person.name // getName하지 않고 바로 가져올 수 있다.
        person.age = 10 // setAge 하지 않아도 됨
    }

    2.
    생성자에서 바로 valicheck를 해보자
    J
    public class JavaPerson(String name, int age) {
        if (age<=0) {throw new ... }
    }

    K
    class Person(val name: String, var age: Int) {
        init { // 초기화 블록
            if (age < 0) {}
        }
    }

    최초로 태어난 아기는 1살이므로 생성자를 하나 더 새로 만든다
    J
    public JavaPerson(String name) { this(name, 1) }

    K
    class Person(val name: String, var age: Int) {
        init { // 초기화 블록
            if (age < 0) {}
        }

        constructor(name: String) : this(name, 1) //name만 인자로 받고 : this(name, 1)이 위의 생성자를 호출하게 된다. Person(val name: String, var age: Int)이거. 이걸 주생성자라고 부름. 반드시 있어야함. 근데 주생성자에 파라미터가 하나도 없다면 생략 가능.
    }

    // 주생성자의 파라미터 없으면
    fun main() {
        Student // 가능
    }
    class Student

    // 부생성자는 반드시 주생성자를 호출해야한다.
    class Person(val name: String, var age: Int) { }
    constructor(name: String): this(name, 1) //얘는 주생성자를 호출
    constructor(): this("홍길동") //얘는 2번을 호출

    3. 커스텀 getter setter
    K
    fun isAdult(): Boolean { return this.age>= 20}
    위와 아래는 같다
    val isAdult: Boolean
        get() { return this.age >= 20 } // custom getter
    get() = this.age >= 20 //위아래같음
    함수 대신 프로퍼티로도 만들 수 있다........

    4.
    class Person(val name: String, var age: Int) { // 주생성자에서 받은 name을
        val name: String = name // 불변 프로퍼티 name에 대입
            get() = filed.uppercase() // 자기자신을 가르키는 예약어 filed, backing filed
    }

    backing field안 쓰는 방법
    class Person 어쩌고 {
        fun getUppercaseName(): String = this.name.uppercase() //와같다
    }

