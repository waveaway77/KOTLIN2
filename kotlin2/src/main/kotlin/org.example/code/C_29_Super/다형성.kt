package org.example.org.example.code.C_29_Super

open class Mother {
    open fun hello() {
        println("hello, i'm mother")
    }
}

class Son : Mother() {
    override fun hello() {
        println("hello, i'm son")
    }
}

class SuperTestClass() {
    private val son: Mother = Son()
    // Mother son = new Son(); // java code
    /*
    Mother = Son()은 "Son을 Mother처럼 다루겠다"는 의미로,
    상위 타입으로 하위 타입 객체를 담는 것 → 업캐스팅,
    실행 시에는 실제 객체 타입을 기준으로 동작함 → 다형성(polymorphism).
    필요한 경우 son as Son으로 다시 다운캐스팅해서 Son만의 멤버에 접근할 수도 있다.
     */
}

class SuperTestClass2() {

    // 다형성의 장점 (1)
    fun a() {
        fun greet(m: Mother) { // Mother 타입으로만 받았지만 다형성 덕분에 Son을 인자로 받아도 문제가 없음.
            m.hello()
        }

        val son = Son()
        val mother = Mother()

        greet(son)    // "hello, i'm son"
        greet(mother) // "hello, i'm mother"
    }

    // 다형성의 장점 (2)
    fun b() {
        val people: List<Mother> = listOf(Son(), Mother(), Son())
        people.forEach { it.hello() }
    }

}
