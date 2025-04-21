package code

class Robot() {
    fun move() = println("move")
}

class A(robot: Robot) { // Robot을 생성자로 받는 클래스 A // a.은 여기에 접근하게 된다.
    fun aaa() = println("aaa")
}

fun main() {
    val a = A(Robot()) // A의 생성자로 객체를 전달
    a.aaa() // 가능
//    a.move() // error. 왜? Robot의 move에 접근이 안된다. 만약 A에 fun move()가 있었다면 오류 안남.

//    val b = A(Robot()::class) // 타입이 일치하지 않습니다.
}