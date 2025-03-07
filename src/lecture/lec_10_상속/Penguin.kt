package lecture.lec_10_상속

abstract class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄")
    }

    override val legCount: Int // 프로퍼티를 상속 받기 위해서는 open이 붙어있어야 한다.
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act() //<타입>.함수()
        super<Flyable>.act()
    }
}