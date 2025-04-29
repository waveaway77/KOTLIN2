package org.example.org.example.code.C_07_generic

open class Person<T>

// 두 개의 제너릭 T는 다른 위치에 있다.
// (1)
data class Success<T>(val data: T) : Person<T>()
// (2)
fun <T> printAnything(value: T) = println(value)

/*
(1) 제너릭 클래스
Success라는 클래스 자체가 제너릭. 이 말의 뜻은 클래스를 정의할 때 타입 파라미터를 받는다는 뜻.
Success는 어떤 타입 T를 받아서 그걸로 동작하는 클래스라는 뜻이다.
클래스 설계할 때부터 타입을 열어두고,
나중에 객체를 만들 때 구체 타입을 정한다는 뜻이다.

이 Success 클래스의 data 필드, BankResult<T> 상속관계 모두 T를 기반으로 동작한다.
Success<T>는 인스턴스를 만들 때마다 타입이 결정된다.

String으로 넣으면, 무조건 String으로 나온다!!! 이걸 위해서 사용한다.
*/
val successString = Success("success") // T는 String
val successInt = Success(1) // T는 int

/*
(2) 제너릭 함수
<T>는 함수에만 적용되는 타입 파라미터다...
 */
fun test() {
    printAnything("success") // T는 String
}

/*
제너릭 클래스
>>> 클래스에 속한 모든 프로퍼티와 메서드가 T를 사용할 수 있다.
>>> 포인트 : 객체를 만들 때 타입을 결정한다.

제너릭 메서드
>>> 함수 하나만 T 타입을 사용한다
>>> 함수 호출 때마다 타입을 알아서 추론한다.
 */