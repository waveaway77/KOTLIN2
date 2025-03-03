package lec_10_상속

abstract class Animal(
    protected val species: String,
    protected open val legCount: Int, // 프로퍼티 오버라이드시에 반드시 open을 붙여주어야한다.
) {
    abstract fun move()
}