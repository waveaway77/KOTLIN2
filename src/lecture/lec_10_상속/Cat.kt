package lecture.lec_10_상속

class Cat(
    species: String // 생성자
) : Animal(species, 4) { // cat클래스를 만들 때 animal의 생성자를 받고 이 클래스에 들어온 것을 인자로 넣어준다.
    override fun move() {
        println("cat class move")
    }
}