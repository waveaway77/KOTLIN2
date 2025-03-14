package code

class Robot() {
    fun move() = println("move")
}

class A(robot: Robot) {
    fun aaa() = println("aaa")
}

fun main() {
    val abc = A(Robot()) // A의 생성자로 객체를 전달
    abc.aaa()
    abc.move() // error


    val abc = A(Robot()::class) // 타입이 일치하지 않습니다.
}