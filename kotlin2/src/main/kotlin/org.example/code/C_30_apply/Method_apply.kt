package org.example.org.example.code.C_30_apply

/*
수신 객체 람다 내부에서 수신 객체의 함수를 사용하지 않고 수신 객체 자신을 다시 반환 하려는 경우에 apply 를 사용합니다.
대표적인 경우가 객체의 초기화 (수신 객체의 프로퍼티 만을 사용)

apply, with, let, also, run
https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29
 */


class Method_apply {

    val peter = Person().apply {
        // apply의 블록에서는 오직 자신의 프로퍼티만 사용합니다!
        name = "Peter"
        age = 18
    }

    // .apply를 사용하지 않는 경우 예제
    val clark = {
        val clark = Person()
        clark.name = "Clark"
        clark.age = 18
    }
}

class Person {
    var name = ""
    var age = 0
}