package lec_10_상속

interface Swimable {

    val swimAblity: Int //
        get() = 3

    fun act() {
        println("Swimable act")
    }
}