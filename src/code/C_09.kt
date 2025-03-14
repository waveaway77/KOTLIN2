package code

class Robot() {
    fun move() = println("move")
}

class A(robot: Robot) {
}

fun main(args: Array<String>) {
    val abc = A(Robot())
    println(abc.javaClass)
}