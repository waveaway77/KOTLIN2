fun main() {
    Derived(300)
    /* 출력
    Base Class
    0
    Derived Class
     */
}

open class Base(
    open val number: Int = 100 // 상속받은 곳에서 사용할 수 있게끔 open
) {
    init {
        println("Base Class")
        println(number) // 0이 나온 이유 : 상위 클래스의 init에서는 하위클래스의 filed에 접근할 경우 0이 나오게 되므로 경고중
    }
}

class Derived(
    override val number: Int
) : Base(number) { // Base를 상속 받음
    init {
        println("Derived Class")
    }
}
/*
1. final : override를 할 수 없게 한다
2. open : override를 열어준다
3. abstract : 반드시 override해야한다
4. override : 상위 타입을 override하고 있다.

상속
- 상속 구현 시 : 을 사용
- 상위 클래스 상속을 구현할 때 생성자 반드시 호출
- override를 필수로 붙여야한다
- 추상 멤버가 아니면 기보적으로 오버라이드가 불가능하다 (open을 사용해야함)
- 상위 클래스 생성자 또는 초기화 블록에서 open프로퍼티를 사용하면 버그가 있을 수 있음
 */