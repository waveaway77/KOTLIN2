/*
1. 변수 선언 키워드 - var & val
2. Kotlin에서의 Primitive Type : boxing unboxing 고려x kotlin이 알아서
3. Kotlin에서의 nullable 변수
4. Kotlin에서의 객체 인스턴스화 : new를 사용하지 않는다
*/

/*
java code
(1) long number1 = 10L; // 가변 변수
(2) final long number2 = 10L; // 불변 변수
(3) Long number3 = 1_000L;
(4) Person person = new Person("홍길동");
 */

fun lec_01() {

    // (1) 가변 변수
    var number1 = 10L // variable
    number1 = 5L

    // (2) 불변 변수
    val number2 = 10L // value
    // number2 = 5L // error

    // kotlin에서는 타입을 추론하기에 명명해주지 않아도 된다
    // 초기값 지정 없이 사용할 경우 타입 지정 필수
    var number10: Long // ok. 지정하고 싶을 경우
    // println(number10) // error

    // val이어도 collection에 element추가가 가능하다

    // 모든 변수는 우선 val로 만든뒤 필요한 경우 var로 변경을 추천

    // 3.
    // kotlin에서는 null은 지정해줘야만 할당이 가능하다. 타입?
    var number11: Long? = 1_000L
    number11 = null // ok.
}