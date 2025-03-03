import lec_12_Object.Person

var person = obj as? Person // obj가 null이 아니라면 Person으로 형변환하고 null이라면 null로 둔다

value is Type // true false
value as Type // value가 Type이면 캐스팅, !Type이면 캐스팅 exception
value as? Type // value==type > casting, value==null > null , value!=Type > null

Any 모든 객체의 최상위 타입 like Object
Any도 null 포함 불가, Any?사용해야함

Unit은 java의 void와 동일
Unit은 그 자체로 타입 인자로 사용 가능 (제네릭)
Unit은 실제 존재하는 타입이라는 것을 표현하기위해 사용함

Nothing : 함수가 정상적으로 끝나지 않았다는 사실을 표현함 (무조건 예외를 반환하거나 무한루프함수에다가 표시해주는 역할)

val person = lec_12_Object.Person("최태현", 100)
System.out.println(Stirng.format("이름: %s", person.name
>> println("이름 : ${person.name})

val name = "최태현"
>> println("이름 : $name)

"""
""".trinIndent()

val str = "ABC"
println(str[0]) // A

=========================

java
if (money1.compareTo(money2) > 0) { ... }
kotlin
if (money1 > money2) { ... }

java 동일성에 == 사용 동등성에 equals 직접호출
kotlin 동일성에 === 동등성에 ==(equals 간접호출)

* lazy 연산
if (fun1() || fun2()) { ... } // fun1이 return true인 경우 fun2검증하지 않고 코드실행

java
if ( 0 <= score && score <= 100 ) {}
kotiln
if (score in 0..100) {}

switch case

return when (score/10) {
    in 90..99-> "a" // 이거도 되고
    8->"b" // 이거도 됨 근데 혼용은 안됨
    7->"c"
    is String -> obj.startswith("A") // 이거도됨
    1, 0, -1 -> println("세개의수) // 이거도 됨
    else -> "D"
}

return when { // ()조건이 없다면 그냥 {}를 수행
    number == 0 -> ...
    number %2 == 0 -> ....
    else -> ...
}
"""
